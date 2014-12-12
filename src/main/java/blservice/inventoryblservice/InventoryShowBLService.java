package blservice.inventoryblservice;

import java.util.ArrayList;

import vo.InventoryBillVO;

public interface InventoryShowBLService {
	
	/**
	 * 查看所有的单据
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:10:19 PM
	 */
	public ArrayList<InventoryBillVO> showGifts();
	public ArrayList<InventoryBillVO> showOverFlow();
	public ArrayList<InventoryBillVO> showLoss();
	public ArrayList<InventoryBillVO> showAlarm();
	
	/**
	 * 查看在审核的各个单据
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:33:03 PM
	 */
	public ArrayList<InventoryBillVO> showGiftsApproving();
	public ArrayList<InventoryBillVO> showOverFlowApproving();
	public ArrayList<InventoryBillVO> showLossApproving();
	public ArrayList<InventoryBillVO> showAlarmApproving();
	
	/**
	 * 查看通过审核的各个单据
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:33:49 PM
	 */
	public ArrayList<InventoryBillVO> showGiftsPass();
	public ArrayList<InventoryBillVO> showOverFlowPass();
	public ArrayList<InventoryBillVO> showLossPass();
	public ArrayList<InventoryBillVO> showAlarmPass();
	
	/**
	 * 查看没通过审核的各个单据
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:34:22 PM
	 */
	public ArrayList<InventoryBillVO> showGiftsFailure();
	public ArrayList<InventoryBillVO> showOverFlowFailure();
	public ArrayList<InventoryBillVO> showLossFailure();
	public ArrayList<InventoryBillVO> showAlarmFailure();
	
	/**
	 * 查看作为草稿的各个单据
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:34:36 PM
	 */
	public ArrayList<InventoryBillVO> showGiftsDraft();
	public ArrayList<InventoryBillVO> showOverFlowDraft();
	public ArrayList<InventoryBillVO> showLossDraft();
	public ArrayList<InventoryBillVO> showAlarmDraft();
}
