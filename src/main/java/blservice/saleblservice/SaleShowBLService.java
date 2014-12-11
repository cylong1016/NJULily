package blservice.saleblservice;

import java.util.ArrayList;

import vo.sale.SalesVO;

public interface SaleShowBLService {
	
	
	/**
	 * 返回给界面层显示全部的销售（销售退货）单
	 * @return 全部的销售（销售退货）单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午4:14:35
	 */
	public ArrayList<SalesVO> showSale();
	public ArrayList<SalesVO> showSaleBack();

	/**
	 * 返回给界面层显示全部在审核的销售（销售退货）单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 1:58:50 AM
	 */
	public ArrayList<SalesVO> showSaleApproving();
	public ArrayList<SalesVO> showSaleBackApproving();
	
	/**
	 * 返回给界面层显示全部通过审核的销售（销售退货）单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 1:59:15 AM
	 */
	public ArrayList<SalesVO> showSalePass();
	public ArrayList<SalesVO> showSaleBackPass();
	
	/**
	 * 返回给界面层显示全部没有通过审批的销售（销售退货）单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:01:47 AM
	 */
	public ArrayList<SalesVO> showSaleFailure();
	public ArrayList<SalesVO> showSaleBackFailure();
}
