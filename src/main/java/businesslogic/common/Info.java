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
		if (IDs.isEmpty()) {
			return new ArrayList<String>();
		}
		for (String id : IDs) {
			if (clientName != null) {
				if (!data.getClient(id).equals(clientName)) {
					IDs.remove(id);
					continue;
				}
			}
			if (salesman != null) {
				if (!data.getSalesman(id).equals(salesman)) {
					IDs.remove(id);
					continue;
				}
			}

			if (storage != null) {
				if (!data.getStorage(id).equals(storage)) {
					IDs.remove(id);
					continue;
					}
				}

		}
		return IDs;
	}

}
