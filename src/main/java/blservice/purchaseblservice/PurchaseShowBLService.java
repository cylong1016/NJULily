package blservice.purchaseblservice;

import java.util.ArrayList;

import vo.PurchaseVO;


public interface PurchaseShowBLService {
	
	
	/**
	 * 返回给界面层显示全部的进货（销进货退货）单
	 * @return 全部的进货（进货退货）单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午4:14:35
	 */
	public ArrayList<PurchaseVO> showPurchase();
	public ArrayList<PurchaseVO> showPurchaseBack();

	/**
	 * 返回给界面层显示全部在审核的进货（进货退货）单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 1:58:50 AM
	 */
	public ArrayList<PurchaseVO> showPurchaseApproving();
	public ArrayList<PurchaseVO> showPurchaseBackApproving();
	
	/**
	 * 返回给界面层显示全部通过审核的进货（进货退货）单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 1:59:15 AM
	 */
	public ArrayList<PurchaseVO> showPurchasePass();
	public ArrayList<PurchaseVO> showPurchaseBackPass();
	
	/**
	 * 返回给界面层显示全部没有通过审批的进货（进货退货）单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:01:47 AM
	 */
	public ArrayList<PurchaseVO> showPurchaseFailure();
	public ArrayList<PurchaseVO> showPurchaseBackFailure();
}
