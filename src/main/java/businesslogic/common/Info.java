package businesslogic.common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PersistentObject;
import dataenum.BillType;
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

	protected ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage, BillType type) throws RemoteException {
		ArrayList<String> IDs = new ArrayList<String>();
		TableInfoService<PO> data = getData();
		if (ID != null) {
			for(String id : data.getAllID(type)) {
				if (id.contains(ID)) {
					IDs.add(id);
				}
			}
		} else {
			IDs = data.getAllID(type);
		}
		if (clientName != null) {
			if (IDs.isEmpty()) {
				return IDs;
			}
			for(String id : IDs) {
				if (data.getClient(id) == null) {
					continue;
				}
				if (!data.getClient(id).equals(clientName)) {
					IDs.remove(id);
				}
			}
		}
		if (salesman != null) {
			if (IDs.isEmpty()) {
				return IDs;
			}
			for(String id : IDs) {
				if (data.getSalesman(id) == null) {
					continue;
				}
				if (!data.getSalesman(id).equals(salesman)) {
					IDs.remove(id);
				}
			}
		}

		if (storage != null) {
			if (IDs.isEmpty()) {
				return IDs;
			}
			for(String id : IDs) {
				if (data.getStorage(id) == null) {
					continue;
				}
				if (!data.getStorage(id).equals(storage)) {
					IDs.remove(id);
				}
			}
		}
		return IDs;
	}

}
