package businesslogicservice;

import java.util.ArrayList;

import dataenum.ClientCategory;
import dataenum.ClientLevel;
import dataenum.FindTypeClient;
import vo.ClientVO;
import message.ResultMessage;

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
	 * 显示客户
	 * @return
	 */
	public ArrayList<ClientVO> show();
	
	/**
	 * 查找客户
	 * @param keywords
	 * @param id
	 * @return
	 */
	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type);
	
	/**
	 * 添加客户
	 * @param kind
	 * @param name
	 * @param level
	 * @param phone
	 * @param address
	 * @param post
	 * @param email
	 * @param salesman
	 * @return
	 */
	public ResultMessage addClient(ClientCategory category, String name, ClientLevel level, 
			String phone, String address, String post, String email, double receivableLimit, String salesman);
	
	/**
	 * 修改客户
	 * @param kind
	 * @param name
	 * @param level
	 * @param phoneNum
	 * @param address
	 * @param email
	 * @param post
	 * @param salesman
	 * @return
	 */
	public ResultMessage updClient(String ID, ClientCategory kind, String name, ClientLevel level, 
			String phoneNum, String address, String email, String post, String salesman);
	
	/**
	 * 删除客户
	 * @param name
	 * @return
	 */
	public ResultMessage deletClient(String ID);
	
	
}
