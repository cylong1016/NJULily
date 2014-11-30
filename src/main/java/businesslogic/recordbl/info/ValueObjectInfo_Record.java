package businesslogic.recordbl.info;

import java.util.ArrayList;

import dataenum.BillType;
import vo.ValueObject;

public interface ValueObjectInfo_Record {
	
	public ArrayList<ValueObject> show(BillType billType);
}
