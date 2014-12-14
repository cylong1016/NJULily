package businesslogic.salebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.SalesPO;
import vo.sale.SalesVO;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.inventorybl.info.SaleInfo_Inventory;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import config.RMIConfig;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.saledataservice.SaleDataService;
import dataservice.saledataservice.SaleInfoService;

public class SaleInfo extends Info<SalesPO> implements SaleInfo_Inventory, SaleInfo_Record, ValueObjectInfo_Record<SalesVO>, ValueObject_Approval<SalesVO>{
	
	private Sale sale;
	
	private String ID;
	
	private ArrayList<String> saleIDs;
	
	private ArrayList<String> backIDs;

	public SaleInfo() {
		sale = new Sale();
	}
	
	public SaleInfo(ArrayList<String> IDs) throws RemoteException {
		sale = new Sale();
		saleIDs = new ArrayList<String>();
		backIDs = new ArrayList<String>();
		for (String id : IDs) {
			saleIDs.addAll(getID(id, null, null, null, BillType.SALE));
			backIDs.addAll(getID(id, null, null, null, BillType.SALEBACK));
		}
	}
	
	protected  TableInfoService<SalesPO> getData() {
		try {
			return (SaleInfoService)Naming.lookup(RMIConfig.PREFIX + SaleInfoService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private SaleDataService getSaleData() {
		return sale.getSaleData();
	}
	
	
	/**
	 * 以下是其他包中的SaleInfo接口的方法
	 */

	/**
	 * 根据查找条件查找销售单，返回销售单的ID集合
	 * String ID 的格式为 yyyyMMdd
	 * @throws RemoteException 
	 */
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) throws RemoteException {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.SALE);
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.SALEBACK));
		return IDs;
	}
	
	public SalesVO find(String ID) throws RemoteException {
		SaleTrans transPOVO = new SaleTrans();
		SalesVO vo = transPOVO.poToVo(getSaleData().find(ID));
		return vo;
	}

	public String getCommodityID(String ID, String commodityName) throws RemoteException {
		this.ID = ID;
		ArrayList<CommodityItemPO> POs= getSaleData().find(ID).getCommodities();
		for (int i = 0; i < POs.size(); i++) {
			if (POs.get(i).getName().equals(commodityName)) {
				return POs.get(i).getID();
			}
		}
		return null;
	}
	
	/**
	 * 为了找到特定销售单中的商品
	 * @param ID 商品的ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:04:04 AM
	 * @throws RemoteException 
	 */
	private CommodityItemPO findCommodityItemPO(String ID) throws RemoteException {
		ArrayList<CommodityItemPO> commodityPo = getSaleData().find(this.ID).getCommodities();
		for (int i = 0; i < commodityPo.size(); i++) {
			if (commodityPo.get(i).getID().equals(ID)) {
				return commodityPo.get(i);
			}
		}
		return null;
	}

	public String getCommodityName(String ID) throws RemoteException {
		return findCommodityItemPO(ID).getName();
	}

	public String getCommodityType(String ID) throws RemoteException {
		return findCommodityItemPO(ID).getType();
	}

	public int getCommodityNumber(String ID) throws RemoteException {
		return findCommodityItemPO(ID).getNumber();
	}

	public double getCommodityPrice(String ID) throws RemoteException {
		return findCommodityItemPO(ID).getPrice();
	}
	
	// 以上都是对销售单中商品列表的某个商品的查询（根据ID）
	
	/**
	 * 查找指定销售单（销售退货单）的折扣后价格（不包括代金券）
	 * @throws RemoteException 
	 */
	public double getBeforePrice(String ID) throws RemoteException {
		SalesPO po = getSaleData().find(ID);
		return po.getBeforePrice();
	}

	/**
	 * 查找指定销售单的代金券
	 * @throws RemoteException 
	 */
	public double getVoucher(String ID) throws RemoteException {
		return getSaleData().find(ID).getVoucher();
	}

	/**
	 * 查找指定销售单的折扣
	 * @throws RemoteException 
	 */
	public double getAllowance(String ID) throws RemoteException {
		return getSaleData().find(ID).getVoucher();
	}

	
	public double getMoney() throws RemoteException {
		if (saleIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		double saleMoney = 0;
		for (String id : saleIDs) {
			saleMoney += getBeforePrice(id);
		}
		for (String id : backIDs) {
			saleMoney -= getBeforePrice(id);
		}
		return saleMoney;
	}

	public int getNumber() throws RemoteException {
		if (saleIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		int saleNumber = 0;
		for (String id : saleIDs) {
			saleNumber += getAllCommoditiesNumber(id);
		}
		for (String id : backIDs) {
			saleNumber -= getAllCommoditiesNumber(id);
		}
		return saleNumber;
	}
	
	/**
	 * 得到一个销售单中的所有商品的数量
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 5:15:27 PM
	 * @throws RemoteException 
	 */
	private int getAllCommoditiesNumber(String ID) throws RemoteException {
		ArrayList<CommodityItemPO> POs = getSaleData().find(ID).getCommodities();
		int number = 0;
		for (CommodityItemPO po : POs) {
			number += po.getNumber();
		}
		return number;
	}
	
	/**
	 * 查找需要审批的单子
	 * @throws RemoteException 
	 */
	public ArrayList<SalesVO> findApproval() throws RemoteException {
		SaleShow saleShow = new SaleShow();
		ArrayList<SalesVO> vo = saleShow.showSaleApproving();
		vo.addAll(saleShow.showSaleBackApproving());
		return vo;
	}

	@Override
	public ArrayList<SalesVO> showPass() throws RemoteException {
		SaleShow saleShow = new SaleShow();
		ArrayList<SalesVO> vo = saleShow.showSalePass();
		vo.addAll(saleShow.showSaleBackPass());
		return vo;
	}

	@Override
	public ArrayList<SalesVO> showFailure() throws RemoteException {
		SaleShow saleShow = new SaleShow();
		ArrayList<SalesVO> vo = saleShow.showSaleFailure();
		vo.addAll(saleShow.showSaleBackFailure());
		return vo;
	}
	

}
