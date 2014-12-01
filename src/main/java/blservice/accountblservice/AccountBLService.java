package blservice.accountblservice;

import java.util.ArrayList;

import message.ResultMessage;
import vo.AccountVO;
import dataenum.FindTypeAccount;

/**
 * 负责实现公司账户界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:15:56 PM
 */
/**
 * 账户管理（账户指的是此家公司的银行账户，仅限最高权限可以查看账户名称和余额。
 * 账号的属性有：名称和金额。余额不可修改，此数据项取决于收款单和付款单。
 * 账户的增删改查包括增加账户、删除账户、修改账户属性和查询账户。
 * 账号的查询可以通过输入关键字进行模糊查找。仅限最高权限可进行这些操作。）
 * @author Zing
 * @version 2014年10月28日下午6:04:46
 */
public interface AccountBLService {

	/**
	 * 界面创建账户的时候获取可用ID
	 * @return ID（供界面显示）
	 * @author cylong
	 * @version 2014年11月30日 下午1:15:10
	 */
	public String getID();

	/**
	 * 显示全部账户
	 * @return 返回全部客户的ArrayList
	 */
	public ArrayList<AccountVO> show();

	/**
	 * 根据关键字和查找类型进行模糊查找
	 * @param keywords 关键字
	 * @param type 查找类型；null为全部类型
	 * @return 全部的账户VO
	 * @author cylong
	 * @version 2014年11月30日 上午2:11:51
	 */
	public ArrayList<AccountVO> find(String keywords, FindTypeAccount type);

	/**
	 * 根据ID精确查找
	 * @param ID 收款单（付款单ID）
	 * @return AccountVO
	 * @author cylong
	 * @version 2014年12月1日 下午5:00:10
	 */
	public AccountVO find(String ID);

	/**
	 * 添加账户
	 * @param vo AccountVO
	 * @return 是否成功
	 * @author cylong
	 * @version 2014年11月30日 上午2:19:17
	 */
	public ResultMessage add(AccountVO vo);

	/**
	 * 按名称删除账户
	 * @param ID
	 * @return 成功与否
	 */
	public ResultMessage delete(String ID);

	/**
	 * 更新账户
	 * @param vo AccountVO
	 * @return 成功与否
	 */
	public ResultMessage update(AccountVO vo);
}
