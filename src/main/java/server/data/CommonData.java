package server.data;

import java.util.ArrayList;

import message.ResultMessage;
import po.PersistentObject;
import server.common.Common;
import server.common.ParseXML;
import server.io.DefineList;
import dataenum.BillType;
import dataservice.CommonDataService;

/**
 * 数据层常用的操作，增删改查
 * @author cylong
 * @version 2014年11月30日 上午10:43:58
 */
public abstract class CommonData<PO extends PersistentObject> implements CommonDataService<PO> {

	protected DefineList<PO> poList;
	/** 保存文件的路径 */
	protected String filePath;
	/** ID前缀 */
	protected String prefix;
	/** 当前最大ID */
	protected int maxID;
	/** ID最大位数 */
	protected int IDMaxBit;
	/** 解析xml文件 */
	protected ParseXML parsexml;
	/** 当天日期 */
	protected String currentDate;
	/** 文件中记录的日期 */
	protected String dateRecord;

	public CommonData() {
		init();	// 初始化parsexml
		filePath = parsexml.getValue("path");
		maxID = Integer.parseInt(parsexml.getValue("maxID"));
		IDMaxBit = Integer.parseInt(parsexml.getValue("IDMaxBit"));
		poList = new DefineList<PO>(filePath);
	}

	/**
	 * @see dataservice.DataService#getID()
	 */
	@Override
	public String getID() {
		String currentID = Common.intToString((maxID += 1), IDMaxBit);
		parsexml.setValue("maxID", currentID);
		return currentID;
	}

	/**
	 * 以单据类型返回单据ID
	 * @param type 单据类型
	 * @return 单据ID
	 * @author cylong
	 * @version 2014年12月2日 下午6:03:39
	 */
	public String getID(BillType type) {
		String preID = getPreID(type);
		if (preID == null) {
			return null;
		}
		if (currentDate.equals(dateRecord)) {
			maxID = Integer.parseInt(parsexml.getValue("maxID"));
		} else {	// 过了一天
			parsexml.setValue("dateRecord", currentDate);
			maxID = 0;	// 初始化最大ID
		}
		String ID = getID();
		if (ID.length() > IDMaxBit) {	// 超过一天单据的最大数量
			return null;
		}
		return preID + ID;
	}

	/**
	 * 按照单子类型返回ID的前缀，由子类实现
	 * @param type
	 * @return
	 * @author cylong
	 * @version 2014年12月2日 下午6:03:32
	 */
	protected String getPreID(BillType type) {
		return null;
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
