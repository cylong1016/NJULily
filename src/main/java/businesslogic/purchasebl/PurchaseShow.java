package businesslogic.purchasebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PurchasePO;
import vo.PurchaseVO;
import dataenum.BillState;
import dataenum.BillType;
import dataservice.purchasedataservice.PurchaseDataService;

public class PurchaseShow {
	
	private PurchaseDataService purchaseData;
	private Purchase purchase;
	public PurchaseShow() {
		this.purchase = new Purchase();
		purchaseData = purchase.getPurData();
	}

	public ArrayList<PurchaseVO> showPurchase() throws RemoteException {
		return showChoose(BillType.PURCHASE);
	}

	public ArrayList<PurchaseVO> showPurchaseBack() throws RemoteException {
		return showChoose(BillType.PURCHASEBACK);
	}

	public ArrayList<PurchaseVO> showPurchaseApproving() throws RemoteException {
		return showChoose(BillType.PURCHASE, BillState.APPROVALING);
	}

	public ArrayList<PurchaseVO> showPurchaseBackApproving() throws RemoteException {
		return showChoose(BillType.PURCHASEBACK, BillState.APPROVALING);
	}

	public ArrayList<PurchaseVO> showPurchasePass() throws RemoteException {
		return showChoose(BillType.PURCHASE, BillState.SUCCESS);
	}

	public ArrayList<PurchaseVO> showPurchaseBackPass() throws RemoteException {
		return showChoose(BillType.PURCHASEBACK, BillState.SUCCESS);
	}

	public ArrayList<PurchaseVO> showPurchaseFailure() throws RemoteException {
		return showChoose(BillType.PURCHASE, BillState.FAILURE);
	}

	public ArrayList<PurchaseVO> showPurchaseBackFailure() throws RemoteException {
		return showChoose(BillType.PURCHASEBACK, BillState.FAILURE);
	}

	/**
	 * 返回所有的VO
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:29:35 AM
	 * @throws RemoteException 
	 */
	private ArrayList<PurchaseVO> show() throws RemoteException {	
		ArrayList<PurchaseVO> VOs = new ArrayList<PurchaseVO>();
		ArrayList<PurchasePO> POs = purchaseData.show();
		for(PurchasePO po : POs) {
			PurchaseVO vo = purchase.poToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}
	
	/**
	 * 根据选择的类型显示
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:17:03 AM
	 * @throws RemoteException 
	 */
	private ArrayList<PurchaseVO> showChoose(BillType type) throws RemoteException {
		ArrayList<PurchaseVO> choose = new ArrayList<PurchaseVO>();
		for (PurchaseVO vo : show()) {
			if (vo.type == type) {
				choose.add(vo);
			}
		}
		return choose;
	}
	
	/**
	 * 根据选择的类型和状态显示
	 * @param type
	 * @param state
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:17:17 AM
	 * @throws RemoteException 
	 */
	private ArrayList<PurchaseVO> showChoose(BillType type, BillState state) throws RemoteException {
		ArrayList<PurchaseVO> choose = new ArrayList<PurchaseVO>();
		for (PurchaseVO vo : show()) {
			if (vo.type == type && vo.state == state) {
				choose.add(vo);
			}
		}
		return choose;
	}
}
