package businesslogic.salebl;

import java.util.ArrayList;

import message.ResultMessage;
import po.SalesPO;
import server.data.saledata.SaleData;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
import vo.promotion.PromotionTotalVO;
import vo.sale.SalesVO;
import vo.sale.saleAddVO;
import blservice.saleblservice.SaleBLService;
import businesslogic.clientbl.ClientInfo;
import businesslogic.promotionbl.PromotionInfo;
import businesslogic.salebl.info.ClientInfo_Sale;
import businesslogic.salebl.info.PromotionInfo_Sale;
import dataenum.BillType;
import dataservice.saledataservice.SaleDataService;

/**
 * 处理销售，创建销售（销售退货单）
 * @author Zing
 * @version Nov 15, 2014 10:07:38 AM
 */
public class Sale implements SaleBLService{

	/** 销售单 */
	private SaleList list;
	/** 销售单持久化对象 */
	private SalesPO po;
	/** 单据类型 */
	/** 根据类型得到单据的ID */
	private BillType type;
	/** 单据的ID */
	private String ID;
	/** 进行转换的POVO */
	SaleTrans transPOVO;
	/** 查看促销信息 */
	PromotionInfo_Sale promotionInfo;
	/** 添加的商品的ID集合 */
	ArrayList<String> commodityIDs;

	public Sale() {
		this.list = new SaleList();
		promotionInfo = new PromotionInfo();
		commodityIDs = new ArrayList<String>();
	}

	public SaleDataService getSaleData() {
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			SaleDataService saleData = factory.getSaleData();
//			return saleData;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
		// TODO 本地新建
		return new SaleData();
	}

	/**
	 * 每次要创建单据前，都要根据单据的类型得到ID，返回给界面显示
	 * 这时候保存单据的Type和ID
	 * @author Zing
	 * @param type
	 * @return ID（界面显示）
	 */
	public String getSaleID() {
		this.type = BillType.SALE;
		SaleDataService saleData = getSaleData();
		this.ID = saleData.getSaleID();
		return ID;
	}
	
	public String getSaleBackID() {
		this.type = BillType.SALEBACK;
		SaleDataService saleData = getSaleData();
		this.ID = saleData.getSaleBackID();
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
		commodityIDs.add(itemVO.ID);
	}
	
	public void addClient(String clientID) {
		list.setClientID(clientID);
	}
	
	/**
	 * 界面显示全部的销售（销售退货）单
	 * @return 销售（销售退货）单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午8:36:47
	 */
	public ArrayList<SalesVO> show(BillType type) {
		transPOVO = new SaleTrans();
		ArrayList<SalesVO> billsVO = new ArrayList<SalesVO>();
		SaleDataService saleData = getSaleData();
		ArrayList<SalesPO> billsPO = saleData.show();
		for(SalesPO po : billsPO) {
			SalesVO vo = transPOVO.poToVo(po);
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
	public ResultMessage submit(saleAddVO inputInfo) {
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
	public ResultMessage save(saleAddVO inputInfo) {
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
		String clientID = list.getClientID();
		String salesman = info.getSalesman(list.getClientID());
		// TODO user从文件中读取当前登陆的用户
		po = new SalesPO(ID, clientID, clientName, salesman, "user", list.getStorage(), list.getCommodities(), beforePrice, list.getAllowance(), list.getVoucher(), list.getRemark(), afterPrice, type);
		return po;
	}

	/**
	 * 设置输入的数据
	 * @param inputInfo
	 * @author Zing
	 * @version Dec 3, 2014 2:42:17 PM
	 */
	private void setInputInfo(saleAddVO inputInfo) {
		list.setStorage(inputInfo.storage);
		list.setAllowance(inputInfo.allowance);
		list.setVoucher(inputInfo.voucher);
		list.setRemark(inputInfo.remark);
	}

	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity() {
		promotionInfo.findFitPromotionCommodity(ID, commodityIDs);
		return null;
	}

	public ArrayList<PromotionClientVO> findFitPromotionClient() {
		promotionInfo.findFitPromotionClient(ID, list.getClientID());
		return null;
	}

	public ArrayList<PromotionTotalVO> findFitPromotionTotal() {
		promotionInfo.findFitPromotionTotal(ID, list.getBeforePrice());
		return null;
	}
	

}
