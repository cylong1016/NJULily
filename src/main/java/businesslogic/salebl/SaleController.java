package businesslogic.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
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
	@Override
	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity() {
		try {
			return sale.findFitPromotionCommodity();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

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
			return sale.submit(inputInfo);
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
			return sale.save(inputInfo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
