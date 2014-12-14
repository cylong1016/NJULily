package businesslogic.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.sale.SalesVO;
import blservice.saleblservice.SaleShowBLService;

/**
 * @see blservice.saleblservice.SaleShowBLService
 * @author cylong
 * @version 2014年12月14日 下午4:13:42
 */
public class SaleShowController implements SaleShowBLService {

	private SaleShow saleShow;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午4:15:22
	 */
	public SaleShowController() {
		saleShow = new SaleShow();
	}

	/**
	 * @see blservice.saleblservice.SaleShowBLService#showSale()
	 */
	@Override
	public ArrayList<SalesVO> showSale() {
		try {
			return saleShow.showSale();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleShowBLService#showSaleBack()
	 */
	@Override
	public ArrayList<SalesVO> showSaleBack() {
		try {
			return saleShow.showSaleBack();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleShowBLService#showSaleApproving()
	 */
	@Override
	public ArrayList<SalesVO> showSaleApproving() {
		try {
			return saleShow.showSaleApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleShowBLService#showSaleBackApproving()
	 */
	@Override
	public ArrayList<SalesVO> showSaleBackApproving() {
		try {
			return saleShow.showSaleBackApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleShowBLService#showSalePass()
	 */
	@Override
	public ArrayList<SalesVO> showSalePass() {
		try {
			return saleShow.showSalePass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleShowBLService#showSaleBackPass()
	 */
	@Override
	public ArrayList<SalesVO> showSaleBackPass() {
		try {
			return saleShow.showSaleBackPass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleShowBLService#showSaleFailure()
	 */
	@Override
	public ArrayList<SalesVO> showSaleFailure() {
		try {
			return saleShow.showSaleFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.saleblservice.SaleShowBLService#showSaleBackFailure()
	 */
	@Override
	public ArrayList<SalesVO> showSaleBackFailure() {
		try {
			return saleShow.showSaleBackFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
