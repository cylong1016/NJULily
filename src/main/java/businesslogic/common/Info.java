package businesslogic.common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PersistentObject;
import dataenum.Storage;
import dataservice.TableInfoService;

/**
 * 查看经营历程表和销售明细表就是查看对应的PO
 * @param <PO>
 * @author cylong
 * @version 2014年12月2日 下午12:15:59
 */
public abstract class Info<PO extends PersistentObject> {

	protected abstract TableInfoService<PO> getData();

	/**
	 * 改过之后的方法，传来的是一个确定的单据ID，只要检查这个单据里面的数据就可以了
	 * 
	 * @throws RemoteException
	 * @author Zing
	 * @version Dec 17, 2014 12:53:33 AM
	 */
	protected ArrayList<String> getID(ArrayList<String> IDs, String clientName, String salesman, Storage storage) throws RemoteException {
		TableInfoService<PO> data = getData();
		if (IDs.isEmpty() || IDs == null) {
			return new ArrayList<String>();
		}
		for (int i=0; i< IDs.size(); ) {
			if (clientName != null) {
				String client = data.getClient(IDs.get(i));
				if (client == null || (!client.equals(clientName))) {
					IDs.remove(i);
					continue;
				}
			}
			if (salesman != null) {
				String sale = data.getSalesman(IDs.get(i));
				if (sale == null || (!sale.equals(salesman))) {
					IDs.remove(i);
					continue;
				}
			}

			if (storage != null) {
				Storage st = data.getStorage(IDs.get(i));
				if (st == null || (!st.equals(storage))) {
					IDs.remove(i);
					continue;
				}
			}
			i++;
		}
		return IDs;
	}

}
