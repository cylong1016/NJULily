package blservice.clientblservice;

import java.util.ArrayList;

import message.ResultMessage;
import vo.ClientVO;
import dataenum.FindTypeClient;

/**
 * 负责实现客户管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:09:50 PM
 */
/**
 * 客户的属性有：
 * 编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、
 * 姓名、电话、地址、邮编、电子邮箱、
 * 应收额度（允许客户欠款的上限，即客户最多可以欠本公司多少钱。取决于该客户的等级，可以为每个等级设置一个默认应收额度。）、
 * 应收、应付、默认业务员。应收应付不可修改，此数据项取决于进货单和销售单，收款单和付款单。
 * 应收额度仅最高权限可修改（ 销售人员可以创建客户，客户的默认应收额度由客户所在的级别决定 ）。
 * 客户的增删改查包括增加客户、删除客户、修改客户属性和查询客户。客户的查询可以通过输入关键字、客户编号等进行模糊查找。
 * @author Zing
 * @version 2014年10月28日下午5:26:29
 */
public interface ClientBLService {

	/**
	 * 界面创建客户的时候获取可用ID
	 * @return ID（供界面显示）
	 * @author cylong
	 * @version 2014年11月29日  下午4:43:54
	 */
	public String getID();
	/**
	 * 显示全部客户
	 * @return 返回全部客户的ArrayList
	 */
	public ArrayList<ClientVO> show();

	/**
	 * 查找客户（模糊查找）
	 * @param keywords 关键字
	 * @param type 按照客户类型查找，null 为模糊查找
	 * @return 满足条件的全部客户
	 * @author cylong
	 * @version 2014年11月29日 下午3:30:49
	 */
	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type);

	/**
	 * 以ID精确查找客户
	 * @param ID 客户
	 * @return ClientVO
	 * @author cylong
	 * @version 2014年12月1日  下午2:54:12
	 */
	public ClientVO findClient(String ID);
	/**
	 * 添加一位客户VO
	 * @param ClientVO
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月29日 下午3:40:03
	 */
	public ResultMessage addClient(ClientVO vo);

	/**
	 * 更新一位客户
	 * @param vo
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月29日 下午3:40:36
	 */
	public ResultMessage updClient(ClientVO vo);

	/**
	 * 以ID删除客户
	 * @param ID
	 * @return 处理信息
	 */
	public ResultMessage deletClient(String ID);

}
