package dataservice.clientdataservice;

import java.util.ArrayList;

import po.ClientPO;
import dataenum.FindTypeClient;
import dataservice.CommonDataService;

/**
 * 提供客户数据集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:53:40 PM
 */
public interface ClientDataService extends CommonDataService<ClientPO> {

	/**
	 * 根据查找类型和关键字查找客户，不区分关键字的大小写
	 * @param keywords
	 * @return 客户持久化数据
	 */
	public ArrayList<ClientPO> find(String keywords, FindTypeClient type);
}
