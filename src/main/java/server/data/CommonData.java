package server.data;

import java.util.ArrayList;

import dataservice.CommonDataService;
import message.ResultMessage;
import po.PersistentObject;
import server.common.Common;
import server.io.DefineList;

/**
 * 数据层常用的操作，增删改查
 * @author cylong
 * @version 2014年11月30日 上午10:43:58
 */
public abstract class CommonData<PO extends PersistentObject> implements CommonDataService<PO> {

	protected DefineList<PO> poList;
	protected String filePath;
	protected String initID;

	public CommonData() {
		init();
	}

	/**
	 * @see dataservice.DataService#getID()
	 */
	@Override
	public String getID() {
		if (poList.isEmpty()) {
			return initID;
		}
		String currentID = poList.get(poList.size() - 1).getID();
		int id = Integer.parseInt(currentID);
		currentID = String.valueOf(id + 1);
		currentID = Common.intToString(id + 1, 7);
		return currentID;
	}

	/**
	 * @see dataservice.CommonDataService#insert(po.PersistentObject)
	 */
	@Override
	public ResultMessage insert(PO po) {
		if (poList.contains(po)) {
			return ResultMessage.FAILURE;
		}
		poList.add(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see dataservice.CommonDataService#find(java.lang.String)
	 */
	@Override
	public PO find(String ID) {
		for(int i = 0; i < poList.size(); i++) {
			if (poList.get(i).getID().equals(ID)) {
				return poList.get(i);
			}
		}
		return null;
	}

	/**
	 * @see dataservice.CommonDataService#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String ID) {
		for(int i = 0; i < poList.size(); i++) {
			if (poList.get(i).getID().equals(ID)) {
				poList.remove(i);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILURE;
	}

	/**
	 * @see dataservice.CommonDataService#update(po.PersistentObject)
	 */
	@Override
	public ResultMessage update(PO po) {
		int index = poList.indexOf(po);
		if (index == -1) {
			return ResultMessage.FAILURE;
		}
		poList.set(index, po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see dataservice.CommonDataService#show()
	 */
	@Override
	public ArrayList<PO> show() {
		return poList.getInList();
	}

}
