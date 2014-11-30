package businesslogic.recordbl.info;

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.Storage;
import vo.ValueObject;

public interface ValueObjectInfo_Record {
	
	public ArrayList<ValueObject> show(BillType billType);
	
	public String getID(String ID, String clientName, String salesman, Storage storage);
}
