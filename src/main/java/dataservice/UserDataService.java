package dataservice;

import java.util.ArrayList;

import message.ResultMessage;
import po.UserPO;

/**
 * 提供用户集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:51:54 PM
 */
public interface UserDataService extends DataService {

	/**
	 * 向序列化文件中添加一个用户
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(UserPO po);

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return 用户持久化用户数据
	 */
	public UserPO find(String username);

	/**
	 * 根据用户ID删除
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);

	/**
	 * 更新用户
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(UserPO po);
	
	/**
	 * 显示全部客户
	 * @return 返回所有客户的集合
 	 * @author cylong
	 * @version Nov 8, 2014  9:35:06 PM
	 */
	public ArrayList<UserPO> show();

}
