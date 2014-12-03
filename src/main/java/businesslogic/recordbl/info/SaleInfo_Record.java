package businesslogic.recordbl.info;

import java.util.ArrayList;

import dataenum.Storage;

public interface SaleInfo_Record {
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage);
	
	/**
	 * 根据销售单的ID，查找特定的商品ID
	 * @param ID
	 * @param CommodityName
	 * @return
	 * @author Zing
	 * @version Dec 3, 2014 2:48:47 PM
	 */
	public String getCommodityID(String ID, String CommodityName);

	public String getCommodityName(String ID);
	
	public String getCommodityType(String ID);
	
	public int getCommodityNumber(String ID);
	
	public double getCommodityPrice(String ID);
	
	public double getBeforePrice(String ID);
		
	public double getVoucher(String ID);
	
	public double getAllowance(String ID);

}
