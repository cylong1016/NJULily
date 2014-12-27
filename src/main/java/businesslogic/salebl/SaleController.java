package businesslogic.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogMsgController;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionTotalVO;
import vo.sale.SalesVO;
import vo.sale.saleAddVO;
import blservice.saleblservice.SaleBLService;

/**
 * @see blservice.saleblservice.SaleBLService
 * @author cylong
 * @version 2014年12月14日 下午4:04:43
 */
public class SaleController implements SaleBLService {

	private Sale sale;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午4:08:16
	 */
	public SaleController() {
		sale = new Sale();
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#getSaleID()
	 */
	@Override
	public String getSaleID() {
		try {
			return sale.getSaleID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#getSaleBackID()
	 */
	@Override
	public String getSaleBackID() {
		try {
			return sale.getSaleBackID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<PromotionBargainVO> showBargains() {
		try {
			return sale.showBargains();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void ddBargains(String ID) {
		try {
			sale.addBargains(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#addCommodities(vo.commodity.CommodityItemVO)
	 */
	@Override
	public void addCommodities(CommodityItemVO item) {
		try {
			sale.addCommodities(item);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#addClient(java.lang.String)
	 */
	@Override
	public void addClient(String clientID) {
		sale.addClient(clientID);
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#findFitPromotionCommodity()
	 */
	//	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity() {
	//		try {
	//			return sale.findFitPromotionCommodity();
	//		} catch (RemoteException e) {
	//			e.printStackTrace();
	//			return null;
	//		}
	//	}

	/**
	 * @see blservice.saleblservice.SaleBLService#findFitPromotionClient()
	 */
	@Override
	public ArrayList<PromotionClientVO> findFitPromotionClient() {
		try {
			return sale.findFitPromotionClient();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#findFitPromotionTotal()
	 */
	@Override
	public ArrayList<PromotionTotalVO> findFitPromotionTotal() {
		try {
			return sale.findFitPromotionTotal();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#submit(vo.sale.saleAddVO)
	 */
	@Override
	public SalesVO submit(saleAddVO inputInfo) {
		try {
			SalesVO vo = sale.submit(inputInfo);
			if (vo != null) {
				LogMsgController.addLog("提交销售（销售退货）单 " + vo.toString());
			}
			return vo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#save(vo.sale.saleAddVO)
	 */
	@Override
	public SalesVO save(saleAddVO inputInfo) {
		try {
			SalesVO vo = sale.save(inputInfo);
			if (vo != null) {
				LogMsgController.addLog("保存销售（销售退货）单为草稿状态 " + vo.toString());
			}
			return vo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
