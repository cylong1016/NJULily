package businesslogic.salebl;

import java.rmi.Naming;
import java.util.ArrayList;

import message.ResultMessage;
import po.SalesPO;
import vo.CommodityItemVO;
import vo.SalesVO;
import blservice.saleblservice.SaleInputInfo;
import businesslogic.clientbl.Client;
import businesslogic.common.CommodityItemPOtoVO;
import config.RMI;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.DataFactoryService;
import dataservice.saledataservice.SaleDataService;

/**
 * 处理销售，创建销售（销售退货单）
 * @author Zing
 * @version Nov 15, 2014 10:07:38 AM
 */
public class Sale extends CommodityItemPOtoVO {

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
	 * 界面显示全部的销售（销售退货）单
	 * @return 销售（销售退货）单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午8:36:47
	 */
	public ArrayList<SalesVO> show(BillType type) {
		ArrayList<SalesVO> billsVO = new ArrayList<SalesVO>();
		SaleDataService saleData = getSaleData();
		ArrayList<SalesPO> billsPO = saleData.show();
		for(int i = 0; i < billsPO.size(); i++) {
			SalesPO po = billsPO.get(i);
			SalesVO vo = poToVo(po);
			billsVO.add(vo);
		}
		return billsVO;
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
	
	/**
	 * 建立销售单
	 * @return SalePO
	 */
	private SalesPO buildSales() {
		double beforePrice = list.getBeforePrice();
		double afterPrice = list.getAfterPrice();
		ClientInfo_Sale info = new ClientInfo();
		String clientName = info.getName(list.getClientID());
		String salesman = info.getSalesman(list.getClientID());
		// TODO user从文件中读取当前登陆的用户
		po = new SalesPO(ID, clientName, salesman, "user", list.getStorage(), list.getCommodities(), beforePrice, list.getAllowance(), list.getVoucher(), list.getRemark(), afterPrice, type);
		return po;
	}

	/**
	 * 将销售（销售退货）单的PO转化成VO
	 * @param po
	 * @return SalesVO
	 * @author cylong
	 * @version 2014年11月28日  下午9:12:11
	 */
	public SalesVO poToVo(SalesPO po) {
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


	private void setInputInfo(SaleInputInfo inputInfo) {
		list.setClientID(inputInfo.clientID);
		list.setStorage(inputInfo.storage);
		list.setAllowance(inputInfo.allowance);
		list.setVoucher(inputInfo.voucher);
		list.setRemark(inputInfo.remark);
	}
	

}
