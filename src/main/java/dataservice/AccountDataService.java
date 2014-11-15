package dataservice;

import java.util.ArrayList;

import message.ResultMessage;
import po.AccountPO;
import dataenum.FindTypeAccount;

/**
 * 提供账户数据集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:53:26 PM
 */
public interface AccountDataService extends DataService {

	/**
	 * 添加一条账户信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(AccountPO po);

	/**
	 * 以keywords查看账户信息，type是以什么方式查找，null代表模糊查找
	 * @param keywords
	 * @return 账户持久化对象
	 */
	public ArrayList<AccountPO> find(String keywords, FindTypeAccount type);

	/**
	 * 以账户名称删除账户
	 * @param name
	 * @return 处理结果
	 */
	public ResultMessage delete(String name);

	/**
	 * 更新账户
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(AccountPO po);

}
