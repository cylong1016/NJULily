package businesslogic.purchasebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.PurchaseVO;
import blservice.purchaseblservice.PurchaseShowBLService;

/**
 * @see blservice.purchaseblservice.PurchaseShowBLService
 * @author cylong
 * @version 2014年12月14日 下午4:22:33
 */
public class PurchaseShowController implements PurchaseShowBLService {

	private PurchaseShow purchaseShow;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午4:24:37
	 */
	public PurchaseShowController() {
		purchaseShow = new PurchaseShow();
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseShowBLService#showPurchase()
	 */
	@Override
	public ArrayList<PurchaseVO> showPurchase() {
		try {
			return purchaseShow.showPurchase();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseShowBLService#showPurchaseBack()
	 */
	@Override
	public ArrayList<PurchaseVO> showPurchaseBack() {
		try {
			return purchaseShow.showPurchaseBackFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseShowBLService#showPurchaseApproving()
	 */
	@Override
	public ArrayList<PurchaseVO> showPurchaseApproving() {
		try {
			return purchaseShow.showPurchaseBackFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseShowBLService#showPurchaseBackApproving()
	 */
	@Override
	public ArrayList<PurchaseVO> showPurchaseBackApproving() {
		try {
			return purchaseShow.showPurchaseBackFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseShowBLService#showPurchasePass()
	 */
	@Override
	public ArrayList<PurchaseVO> showPurchasePass() {
		try {
			return purchaseShow.showPurchaseBackFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseShowBLService#showPurchaseBackPass()
	 */
	@Override
	public ArrayList<PurchaseVO> showPurchaseBackPass() {
		try {
			return purchaseShow.showPurchaseBackFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseShowBLService#showPurchaseFailure()
	 */
	@Override
	public ArrayList<PurchaseVO> showPurchaseFailure() {
		try {
			return purchaseShow.showPurchaseBackFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.purchaseblservice.PurchaseShowBLService#showPurchaseBackFailure()
	 */
	@Override
	public ArrayList<PurchaseVO> showPurchaseBackFailure() {
		try {
			return purchaseShow.showPurchaseBackFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
