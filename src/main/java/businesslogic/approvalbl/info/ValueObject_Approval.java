package businesslogic.approvalbl.info;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ValueObject;

public interface ValueObject_Approval<VO extends ValueObject> {
	
	/**
	 * 查找需要审批的单子
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 12:18:38 AM
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public ArrayList<VO> findApproval() throws MalformedURLException, RemoteException, NotBoundException;
	
	/**
	 * 查找通过审批的单子
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 3:09:35 PM
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public ArrayList<VO> showPass() throws MalformedURLException, RemoteException, NotBoundException;
	
	/**
	 * 查找审批失败的单子
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 3:09:46 PM
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public ArrayList<VO> showFailure() throws MalformedURLException, RemoteException, NotBoundException;
}
