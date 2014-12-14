package businesslogic.purchasebl;

import java.rmi.RemoteException;

import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;
import blservice.purchaseblservice.PurInputInfo;
import blservice.purchaseblservice.PurchaseBLService;

/**
 * @see blservice.purchaseblservice.PurchaseBLService
 * @author cylong
 * @version 2014年12月14日 下午4:18:07
 */
public class PurchaseController implements PurchaseBLService {

	private Purchase purchase;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午4:20:02
	 */
	public PurchaseController() {
		purchase = new Purchase();
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseBLService#getPurchaseID()
	 */
	@Override
	public String getPurchaseID() {
		try {
			return purchase.getPurchaseID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseBLService#getPurBackID()
	 */
	@Override
	public String getPurBackID() {
		try {
			return purchase.getPurBackID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseBLService#addCommodities(vo.commodity.CommodityItemVO)
	 */
	@Override
	public void addCommodities(CommodityItemVO item) {
		try {
			purchase.addCommodities(item);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseBLService#submit(blservice.purchaseblservice.PurInputInfo)
	 */
	@Override
	public PurchaseVO submit(PurInputInfo info) {
		try {
			return purchase.submit(info);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseBLService#save(blservice.purchaseblservice.PurInputInfo)
	 */
	@Override
	public PurchaseVO save(PurInputInfo info) {
		try {
			return purchase.save(info);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
