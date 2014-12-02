package businesslogic.common;

import java.util.ArrayList;

import po.PersistentObject;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;

public abstract class Info<ApprovalPO extends PersistentObject> {
	/* 你这样改是什么意思？？这个类是为了给查看经营历程表用的，为什么是ApprovalPO？？？？
	 */
	protected abstract TableInfoService<ApprovalPO> getData();

	protected ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage, BillType type) {
		ArrayList<String> IDs = new ArrayList<String>();
		TableInfoService<ApprovalPO> data = getData();
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
