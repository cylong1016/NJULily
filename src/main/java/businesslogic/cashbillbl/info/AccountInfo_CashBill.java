package businesslogic.cashbillbl.info;

import java.rmi.RemoteException;

public interface AccountInfo_CashBill {

	public void changeMoney(String account, double money) throws RemoteException;
}
