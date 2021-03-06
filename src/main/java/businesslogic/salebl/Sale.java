package businesslogic.salebl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import log.ui.warning.PromptDialog;
import po.SalesPO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
import vo.promotion.PromotionTotalVO;
import vo.sale.SalesVO;
import vo.sale.saleAddVO;
import businesslogic.clientbl.ClientInfo;
import businesslogic.promotionbl.PromotionInfo;
import businesslogic.salebl.info.ClientInfo_Sale;
import businesslogic.salebl.info.PromotionInfo_Sale;
import businesslogic.userbl.UserInfo;
import config.RMIConfig;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataservice.saledataservice.SaleDataService;

/**
 * 处理销售，创建销售（销售退货单）
 * @author Zing
 * @version Nov 15, 2014 10:07:38 AM
 */
public class Sale {

	/** 销售单 */
	private SaleList list;
	/** 销售单数据 */
	private SaleDataService saleData;
	/** 销售单持久化对象 */
	private SalesPO po;
	/** 单据类型 */
	/** 根据类型得到单据的ID */
	private BillType type;
	/** 单据的ID */
	private String ID;
	/** 查看促销信息 */
	PromotionInfo_Sale promotionInfo;
	/** 添加的商品的ID集合 */
	ArrayList<String> commodityIDs;
	ArrayList<Integer> commodityNumber;

	public Sale() {
		this.list = new SaleList();
		promotionInfo = new PromotionInfo();
		commodityIDs = new ArrayList<String>();
		commodityNumber = new ArrayList<Integer>();
		saleData = getSaleData();
	}

	public SaleDataService getSaleData() {
		try {
			return (SaleDataService)Naming.lookup(RMIConfig.PREFIX + SaleDataService.NAME);
		} catch (Exception e) {
			PromptDialog.showConnectionError();
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 每次要创建单据前，都要根据单据的类型得到ID，返回给界面显示
	 * 这时候保存单据的Type和ID
	 * @author Zing
	 * @param type
	 * @return ID（界面显示）
	 * @throws RemoteException
	 */
	public String getSaleID() throws RemoteException {
		this.type = BillType.SALE;
		this.ID = saleData.getSaleID();
		return ID;
	}

	public String getSaleBackID() throws RemoteException {
		this.type = BillType.SALEBACK;
		this.ID = saleData.getSaleBackID();
		return ID;
	}

	public ArrayList<PromotionBargainVO> showBargains() throws RemoteException {
		return promotionInfo.showBargains();
	}

	public void addBargains(String ID) throws RemoteException {
		PromotionBargainVO bargain = promotionInfo.findBargains(ID);
		ArrayList<CommodityItemVO> commodityVOs = bargain.bargains;
		for(CommodityItemVO vo : commodityVOs) {
			addCommodities(vo);
		}
		list.setVoucher(bargain.beforeTotal - bargain.bargainTotal);
	}

	/**
	 * 添加一条商品信息
	 * @param itemVO
	 * @author Zing
	 * @version 2014年11月28日 下午8:02:29
	 * @throws RemoteException
	 */
	public void addCommodities(CommodityItemVO itemVO) throws RemoteException {
		SaleListItem item = new SaleListItem(itemVO.ID, itemVO.number, itemVO.price, itemVO.remark);
		list.add(item);
		commodityIDs.add(itemVO.ID);
		commodityNumber.add(itemVO.number);
	}

	public void addClient(String clientID) {
		list.setClientID(clientID);
	}

	/**
	 * @deprecated 没你什么事了~
	 */
	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity() throws RemoteException {
		// promotionInfo.findFitPromotionCommodity(ID, commodityIDs, commodityNumber);
		return null;
	}

	public ArrayList<PromotionClientVO> findFitPromotionClient() throws RemoteException {
		return promotionInfo.findFitPromotionClient(ID, list.getClientID());
	}

	public ArrayList<PromotionTotalVO> findFitPromotionTotal() throws RemoteException {
		return promotionInfo.findFitPromotionTotal(ID, list.getBeforePrice());
	}
	
	public double setPromotion(String PromotionID) throws RemoteException {
		double zherang = promotionInfo.getAllowance(PromotionID);
//		ArrayList<CommodityItemPO> gifts = promotionInfo.getGifts(PromotionID);
		if (zherang == 0) {
			zherang = 1;
		}
		
		double all = (1-zherang) * list.getBeforePrice();
		DecimalFormat df = new DecimalFormat("0.0");
		double allowance = Double.parseDouble(df.format(all));
		list.setAllowance(allowance);
		return allowance;
	}

	/**
	 * 提交销售（销售退货）单，等待审批
	 * @param inputInfo
	 * @author Zing
	 * @version 2014年11月28日 下午9:13:52
	 * @throws RemoteException
	 */
	public SalesVO submit(saleAddVO inputInfo) throws RemoteException {
		setInputInfo(inputInfo);
		SalesPO po = buildSales();
		saleData.insert(po);
		return SaleTrans.poToVo(po);
	}

	/**
	 * 将销售（销售退货）单保存成草稿状态
	 * @param inputInfo
	 * @author cylong
	 * @version 2014年11月28日 下午9:14:47
	 * @throws RemoteException
	 */
	public SalesVO save(saleAddVO inputInfo) throws RemoteException {
		setInputInfo(inputInfo);
		SalesPO po = buildSales();
		po.setState(BillState.DRAFT);
		saleData.insert(po);
		return SaleTrans.poToVo(po);
	}
	
	public ResultMessage updateDraft(SalesVO vo) throws RemoteException {
		SalesPO po = SaleTrans.VOtoPO(vo);
		return saleData.update(po);
	}

	public ResultMessage submitDraft(String ID) throws RemoteException {
		SalesPO po = saleData.find(ID);
		po.setState(BillState.APPROVALING);
		return saleData.update(po);
	}

	/**
	 * 建立销售单
	 * @return SalePO
	 * @throws RemoteException
	 */
	private SalesPO buildSales() throws RemoteException {
		double beforePrice = list.getBeforePrice();
		double afterPrice = list.getAfterPrice();
		ClientInfo_Sale clientInfo = new ClientInfo();
		String clientName = clientInfo.getName(list.getClientID());
		String clientID = list.getClientID();
		String salesman = clientInfo.getSalesman(list.getClientID());
		UserInfo userInfo = UserInfo.getInstance();
		String username = userInfo.getUsername();
		po = new SalesPO(ID, clientID, clientName, salesman, username, list.getStorage(), list.getCommodities(), beforePrice, list.getAllowance(), list.getVoucher(), list.getRemark(), afterPrice, type);
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

}
