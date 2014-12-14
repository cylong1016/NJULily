package businesslogic.recordbl.info;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.Storage;
import vo.ValueObject;

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
	 * 
	 * @param ID 格式为：yyyyMMdd，表示查找在这个日期是否生成了单据
	 * @param clientName 客户名
	 * @param salesman 业务员
	 * @param storage 仓库
	 * @return 符合条件的单据的ID（一个）
	 * @author Zing
	 * @version Dec 1, 2014 2:17:52 PM
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) throws RemoteException, MalformedURLException, NotBoundException;
}
