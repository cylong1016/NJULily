package businesslogic.purchasebl;

import java.util.ArrayList;

import po.PurchasePO;
import dataenum.BillState;
import dataenum.BillType;
import dataservice.purchasedataservice.PurchaseDataService;
import vo.PurchaseVO;
import blservice.purchaseblservice.PurchaseShowBLService;

public class PurchaseShow implements PurchaseShowBLService{
	
	private PurchaseDataService purchaseData;
	private Purchase purchase;
	public PurchaseShow() {
		this.purchase = new Purchase();
		purchaseData = purchase.getPurData();
	}

	@Override
	public ArrayList<PurchaseVO> showPurchase() {
		return showChoose(BillType.PURCHASE);
	}

	@Override
	public ArrayList<PurchaseVO> showPurchaseBack() {
		return showChoose(BillType.PURCHASEBACK);
	}

	@Override
	public ArrayList<PurchaseVO> showPurchaseApproving() {
		return showChoose(BillType.PURCHASE, BillState.APPROVALING);
	}

	@Override
	public ArrayList<PurchaseVO> showPurchaseBackApproving() {
		return showChoose(BillType.PURCHASEBACK, BillState.APPROVALING);
	}

	@Override
	public ArrayList<PurchaseVO> showPurchasePass() {
		return showChoose(BillType.PURCHASE, BillState.SUCCESS);
	}

	@Override
	public ArrayList<PurchaseVO> showPurchaseBackPass() {
		return showChoose(BillType.PURCHASEBACK, BillState.SUCCESS);
	}

	@Override
	public ArrayList<PurchaseVO> showPurchaseFailure() {
		return showChoose(BillType.PURCHASE, BillState.FAILURE);
	}

	@Override
	public ArrayList<PurchaseVO> showPurchaseBackFailure() {
		return showChoose(BillType.PURCHASEBACK, BillState.FAILURE);
	}

	/**
	 * 返回所有的VO
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:29:35 AM
	 */
	private ArrayList<PurchaseVO> show() {	
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
	 */
	private ArrayList<PurchaseVO> showChoose(BillType type) {
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
	 */
	private ArrayList<PurchaseVO> showChoose(BillType type, BillState state) {
		ArrayList<PurchaseVO> choose = new ArrayList<PurchaseVO>();
		for (PurchaseVO vo : show()) {
			if (vo.type == type && vo.state == state) {
				choose.add(vo);
			}
		}
		return choose;
	}
}
