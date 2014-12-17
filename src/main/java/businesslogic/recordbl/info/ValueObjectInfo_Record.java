package businesslogic.recordbl.info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ValueObject;
import dataenum.Storage;

public interface ValueObjectInfo_Record<VO extends ValueObject> {

	/**
	 * 根据得到的单据ID，返回一个单据
	 * @param ID 单据ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 2:32:24 PM
	 * @throws RemoteException
	 */
	public VO find(String ID) throws RemoteException;

	/**
	 * 得到确定的ID
	 * @author Zing
	 * @version Dec 1, 2014 2:17:52 PM
	 * @throws RemoteException
	 */
	public ArrayList<String> getID(String clientName, String salesman, Storage storage) throws RemoteException;
}
