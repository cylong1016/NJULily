package businesslogic.salebl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.CommodityItemPO;
import po.SalesPO;
import vo.sale.SalesVO;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.common.DateOperate;
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

public class SaleInfo extends Info<SalesPO> implements SaleInfo_Inventory, SaleInfo_Record, ValueObjectInfo_Record<SalesVO>, ValueObject_Approval<SalesVO> {

	private Sale sale;
	private String ID;
	private SaleDataService saleData;
	private ArrayList<String> saleIDs;
	private ArrayList<String> backIDs;

	public SaleInfo() {
		sale = new Sale();
		this.saleData = sale.getSaleData();
	}

	public SaleInfo(Date beginDate, Date endDate) {
		sale = new Sale();
		saleIDs = new ArrayList<String>();
		backIDs = new ArrayList<String>();
		setIDsByDate(beginDate, endDate);
	}

	/**
	 * 找到符合条件的ID
	 */
	private void setIDsByDate(Date beginDate, Date endDate) {
		try {
			SaleInfoService saleInfo = (SaleInfoService)getData();
			ArrayList<String> IDs = saleInfo.getAllID(BillType.SALE);
			for (String id : IDs) {
				System.out.println(id);
			}
			saleIDs = DateOperate.findFitDate(IDs, beginDate, endDate);
			ArrayList<String> bIDs = saleInfo.getAllID(BillType.SALEBACK);
			backIDs = DateOperate.findFitDate(bIDs, beginDate, endDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected TableInfoService<SalesPO> getData() {
		try {
			return (SaleInfoService)Naming.lookup(RMIConfig.PREFIX + SaleInfoService.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 以下是其他包中的SaleInfo接口的方法
	 */

	/**
	 * 根据查找条件查找销售单，返回销售单的ID集合
	 * String ID 的格式为 yyyyMMdd
	 * @throws RemoteException
	 */
	public ArrayList<String> getID(String clientName, String salesman, Storage storage) throws RemoteException {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs.addAll(getSaleIDs(clientName, salesman, storage));
		IDs.addAll(getSaleBackIDs(clientName, salesman, storage));
		return IDs;
	}

	@Override
	public ArrayList<String> getSaleIDs(String clientName, String salesman, Storage storage) throws RemoteException {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(saleIDs, clientName, salesman, storage);
		return IDs;
	}

	public ArrayList<String> getSaleBackIDs(String clientName, String salesman, Storage storage) throws RemoteException {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(backIDs, clientName, salesman, storage);
		return IDs;
	}

	/**
	 * 找到某个单据
	 */
	public SalesVO find(String ID) throws RemoteException {
		SalesVO vo = SaleTrans.poToVo(saleData.find(ID));
		return vo;
	}

	public String getCommodityID(String ID, String commodityName) throws RemoteException {
		this.ID = ID;
		ArrayList<CommodityItemPO> POs = saleData.find(ID).getCommodities();
		for(CommodityItemPO po : POs) {
			if (po.getName().equals(commodityName)) {
				return po.getID();
			}
		}
		return null;
	}

	public ArrayList<String> getAllCommodityID(String ID) throws RemoteException {
		this.ID = ID;
		ArrayList<CommodityItemPO> POs = saleData.find(ID).getCommodities();
		ArrayList<String> commodityIDs = new ArrayList<String>();
		for(CommodityItemPO po : POs) {
			commodityIDs.add(po.getID());
		}
		return commodityIDs;
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
		ArrayList<CommodityItemPO> commodityPo = saleData.find(this.ID).getCommodities();
		for(CommodityItemPO po : commodityPo) {
			if (po.getID().equals(ID)) {
				return po;
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
		SalesPO po = saleData.find(ID);
		return po.getBeforePrice();
	}

	/**
	 * 查找指定销售单的代金券
	 * @throws RemoteException
	 */
	public double getVoucher(String ID) throws RemoteException {
		return saleData.find(ID).getVoucher();
	}

	/**
	 * 查找指定销售单的折扣
	 * @throws RemoteException
	 */
	public double getAllowance(String ID) throws RemoteException {
		return saleData.find(ID).getVoucher();
	}

	public double getMoney() throws RemoteException {
		if (saleIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		double saleMoney = 0;
		for(String id : saleIDs) {
			saleMoney += getBeforePrice(id);
		}
		for(String id : backIDs) {
			saleMoney -= getBeforePrice(id);
		}
		return saleMoney;
	}

	public int getNumber() throws RemoteException {
		if (saleIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		int saleNumber = 0;
		for(String id : saleIDs) {
			saleNumber += getAllCommoditiesNumber(id);
		}
		for(String id : backIDs) {
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
		ArrayList<CommodityItemPO> POs = saleData.find(ID).getCommodities();
		int number = 0;
		for(CommodityItemPO po : POs) {
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
