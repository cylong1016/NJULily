package server.data.accountinitdata;

import java.util.ArrayList;

import message.ResultMessage;
import po.AccountaInitPO;
import server.common.Common;
import server.common.ParseXML;
import server.io.DefineList;
import dataservice.accountinitdataservice.AccountaInitDataService;

/**
 * @author cylong
 * @version 2014年12月2日 下午8:37:30
 */
public class AccountInitData implements AccountaInitDataService {

	protected DefineList<AccountaInitPO> initList;
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

	public AccountInitData() {
		init();
	}

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("AccountInitData");
		filePath = parsexml.getValue("path");
		prefix = parsexml.getValue("prefix");
		maxID = Integer.parseInt(parsexml.getValue("maxID"));
		IDMaxBit = Integer.parseInt(parsexml.getValue("IDMaxBit"));
		initList = new DefineList<AccountaInitPO>(filePath);
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
	 * @see dataservice.DataService#find(java.lang.String)
	 */
	@Override
	public AccountaInitPO find(String ID) {
		for(int i = 0; i < initList.size(); i++) {
			if (initList.get(i).getID().equals(ID)) {
				return initList.get(i);
			}
		}
		return null;
	}

	/**
	 * @see dataservice.accountinitdataservice.AccountaInitDataService#insert(po.AccountaInitPO)
	 */
	@Override
	public ResultMessage insert(AccountaInitPO po) {
		if (initList.contains(po)) {
			return ResultMessage.FAILURE;
		}
		initList.add(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see dataservice.accountinitdataservice.AccountaInitDataService#show()
	 */
	@Override
	public ArrayList<AccountaInitPO> show() {
		return initList.getInList();
	}

}
