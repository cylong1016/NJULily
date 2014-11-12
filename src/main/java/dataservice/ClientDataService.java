package dataservice;

import java.util.ArrayList;

import message.ResultMessage;
import po.ClientPO;
import dataenum.FindTypeClient;

/**
 * 提供客户数据集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:53:40 PM
 */
public interface ClientDataService extends DataService {

	/**
	 * 添加一条客户信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(ClientPO po);

	/**
	 * 根据查找类型和关键字查找客户，不区分关键字的大小写
	 * @param keywords
	 * @return 客户持久化数据
	 */
	public ArrayList<ClientPO> find(String keywords, FindTypeClient type);

	/**
	 * 以ID删除客户信息
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);

	/**
	 * 更新客户信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(ClientPO po);
	
	/**
	 * 显示全部的客户
	 * @return 返回
	 * @author cylong
	 * @version Nov 8, 2014  9:36:35 PM
	 */
	public ArrayList<ClientPO> show();

}
