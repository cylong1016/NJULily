package businesslogic.recordbl.info;

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.Storage;

public interface InventoryInfo_Record {

	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage);

	/**
	 * 得到该库存单据的类型
	 * @param iD
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 11:29:25 PM
	 */
	public BillType getType(String iD);

	/**
	 * 得到该单据的总收入
	 * @param iD
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 11:31:07 PM
	 */
	public double getTotalPrice(String iD);
}
