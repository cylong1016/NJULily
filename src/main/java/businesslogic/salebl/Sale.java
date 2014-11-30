package businesslogic.salebl;

import java.rmi.Naming;
import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityItemPO;
import po.CommodityPO;
import po.SalesPO;
import vo.CommodityItemVO;
import vo.SalesVO;
import vo.ValueObject;
import blservice.saleblservice.SaleInputInfo;
import businesslogic.clientbl.Client;
import businesslogic.commoditybl.Commodity;
import businesslogic.inventorybl.info.SaleInfo_Inventory;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import config.RMI;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.DataFactoryService;
import dataservice.SaleDataService;

/**
 * 处理销售，创建销售（销售退货单）
 * @author Zing
 * @version Nov 15, 2014 10:07:38 AM
 */
public class Sale implements SaleInfo_Inventory, SaleInfo_Record, ValueObjectInfo_Record{

	/** 销售单 */
	private SaleList list;

	/** 销售单持久化对象 */
	private SalesPO po;

	/** 单据类型 */
	/** 根据类型得到单据的ID */
	private BillType type;

	/** 单据的ID */
	private String ID;

	public Sale() {
		this.list = new SaleList();
	}

	public SaleDataService getSaleData() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			SaleDataService saleData = factory.getSaleData();
			return saleData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 每次要创建单据前，都要根据单据的类型得到ID，返回给界面显示
	 * 这时候保存单据的Type和ID
	 * @author Zing
	 * @param type
	 * @return ID（界面显示）
	 */
	public String getID(BillType type) {
		this.type = type;
		SaleDataService saleData = getSaleData();
		this.ID = saleData.getID(type);
		return ID;
	}

	/**
	 * 添加一条商品信息
	 * @param itemVO 
	 * @author Zing
	 * @version 2014年11月28日 下午8:02:29
	 */
	public void addCommodities(CommodityItemVO itemVO) {
		SaleListItem item = new SaleListItem(itemVO.ID, itemVO.number, itemVO.price, itemVO.remark);
		list.add(item);
	}

	/**
	 * 建立销售单
	 * @return SalePO
	 */
	private SalesPO buildSales() {
		double beforePrice = list.getBeforePrice();
		double afterPrice = list.getAfterPrice();
		ClientInfo_Sale info = new Client();
		String clientName = info.getName(list.getClientID());
		String salesman = info.getSalesman(list.getClientID());
		// TODO user从文件中读取当前登陆的用户
		po = new SalesPO(ID, clientName, salesman, "user", list.getStorage(), list.getCommodities(), beforePrice, list.getAllowance(), list.getVoucher(), list.getRemark(), afterPrice, type);
		return po;
	}

	/**
	 * 界面显示全部的销售（销售退货）单
	 * @return 销售（销售退货）单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午8:36:47
	 */
	// TODO 按类型分吧？
	// 这样改行不行？
	public ArrayList<ValueObject> show(BillType type) {
		ArrayList<ValueObject> billsVO = new ArrayList<ValueObject>();
		SaleDataService saleData = getSaleData();
		ArrayList<SalesPO> billsPO = saleData.getAllSaleBills();
		for(int i = 0; i < billsPO.size(); i++) {
			SalesPO po = billsPO.get(i);
			SalesVO vo = poToVo(po);
			billsVO.add(vo);
		}
		return billsVO;
	}

	/**
	 * 将销售（销售退货）单的PO转化成VO
	 * @param po
	 * @return SalesVO
	 * @author cylong
	 * @version 2014年11月28日  下午9:12:11
	 */
	private SalesVO poToVo(SalesPO po) {
		String ID = po.getID();
		String client = po.getClient();
		Storage storage = po.getStorage();
		String salesman = po.getSalesman();
		String user = po.getUser();
		String remark = po.getRemark();
		double beforePrice = po.getBeforePrice();
		double allowance = po.getAllowance();
		double voucher = po.getVoucher();
		double afterPrice = po.getAfterPrice();
		BillType type = po.getType();
		BillState state = po.getState();
		ArrayList<CommodityItemVO> commodities = itemPOToVO(po.getCommodities());
		SalesVO vo = new SalesVO(ID, client, storage, user, salesman, commodities, remark, beforePrice, allowance, voucher, afterPrice, type, state);
		return vo;
	}

	/**
	 * 销售（销售退货）单中的商品条目PO转化成VO
	 * @param itemsPO
	 * @return
	 * @author cylong
	 * @version 2014年11月28日  下午9:12:57
	 */
	private ArrayList<CommodityItemVO> itemPOToVO(ArrayList<CommodityItemPO> itemsPO) {
		ArrayList<CommodityItemVO> itemsVO = new ArrayList<CommodityItemVO>();
		for(int i = 0; i < itemsPO.size(); i++) {
			CommodityItemPO po = itemsPO.get(i);
			String ID = po.getID();
			int number = po.getNumber();
			double price = po.getPrice();
			String remark = po.getRemark();
			CommodityInfo_Sale info = new Commodity();
			String name = info.getName(ID);
			String type = info.getType(ID);
			CommodityItemVO vo = new CommodityItemVO(ID, number, price, remark, name, type);
			itemsVO.add(vo);
		}
		return itemsVO;
	}

	/**
	 * 提交销售（销售退货）单，等待审批
	 * @param inputInfo
	 * @author Zing
	 * @version 2014年11月28日  下午9:13:52
	 */
	public ResultMessage submit(SaleInputInfo inputInfo) {
		setInputInfo(inputInfo);
		SalesPO po = buildSales();
		return getSaleData().insert(po);
	}

	/**
	 * 将销售（销售退货）单保存成草稿状态
	 * @param inputInfo
	 * @author cylong
	 * @version 2014年11月28日  下午9:14:47
	 */
	public ResultMessage save(SaleInputInfo inputInfo) {
		setInputInfo(inputInfo);
		// SalesPO po = buildSales();
		// TODO 保存在本地
		return ResultMessage.SUCCESS;
	}

	private void setInputInfo(SaleInputInfo inputInfo) {
		list.setClientID(inputInfo.clientID);
		list.setStorage(inputInfo.storage);
		list.setAllowance(inputInfo.allowance);
		list.setVoucher(inputInfo.voucher);
		list.setRemark(inputInfo.remark);
	}

	public ArrayList<Double> getMoney(String begin, String end) {
		// TODO 需要根据日期查询ID的方法，返回我一个arrylistID。或者我自己查，那就提供一个返回所有PO的方法
		//		SaleDataService saleData = getSaleData();
		return null;
	}

	public ArrayList<Integer> getNumber(String begin, String end) {
		return null;
	}

	public String getSaleDetailVO(String ID, String clientName, String salesman, Storage storage) {
		SaleDataService saleData = getSaleData();
		ArrayList<String> IDs = saleData.getAllID(BillType.SALE);
		for (int i = 0; i < IDs.size(); i++) {
			SalesPO po = saleData.find(IDs.get(i));
			if (IDs.get(i).contains(ID)) {
				if (po.getClient().equals(clientName) && po.getSalesman().endsWith(salesman) && po.getStorage().equals(storage)) {
					return IDs.get(i);
				}
			}
		}
		return null;
	}

	public String getCommodity(String ID, String commodityName) {
		this.ID = ID;
		ArrayList<CommodityItemPO> POs= getSaleData().find(ID).getCommodities();
		for (int i = 0; i < POs.size(); i++) {
			if (POs.get(i).getName().equals(commodityName)) {
				return POs.get(i).getID();
			}
		}
		return null;
	}

	public String getName(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getType(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumber(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getPrice(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ValueObject> getBills(BillType billType) {
		// TODO Auto-generated method stub
		return null;
	}

}
