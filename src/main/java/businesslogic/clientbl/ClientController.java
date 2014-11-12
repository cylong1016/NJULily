package businesslogic.clientbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.ClientVO;
import vo.UserVO;
import dataenum.ClientCategory;
import dataenum.ClientLevel;
import dataenum.FindTypeClient;
import businesslogicservice.ClientBLService;

/**
 * 实现客户的ClientBLService接口
 * 客户的属性有：
 * 编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、
 * 姓名、电话、地址、邮编、电子邮箱、
 * 应收额度（允许客户欠款的上限，即客户最多可以欠本公司多少钱。取决于该客户的等级，可以为每个等级设置一个默认应收额度。）、
 * 应收、应付、默认业务员。应收应付不可修改，此数据项取决于进货单和销售单，收款单和付款单。
 * 应收额度仅最高权限可修改（ 销售人员可以创建客户，客户的默认应收额度由客户所在的级别决定 ）。
 * 客户的增删改查包括增加客户、删除客户、修改客户属性和查询客户。客户的查询可以通过输入关键字、客户编号等进行模糊查找。
 * @author Zing
 * @version 2014年11月8日下午9:36:26
 */
public class ClientController implements ClientBLService{
	
	private Client client;

	public ArrayList<ClientVO> show() {
		return client.show();
	}

	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type) {
		return client.findClient(keywords, type);
	}

	public ResultMessage addClient(ClientCategory category, String name, ClientLevel level,
			String phone, String address, String post, String email,double receivableLimit,
			String salesman) {
		return client.addClient(category, name, level, phone, address, post, email, receivableLimit, salesman);
	}

	public ResultMessage deletClient(String ID) {
		return client.deletClient(ID);
	}

	public ResultMessage updClient(String ID, ClientCategory kind, String name,
			ClientLevel level, String phoneNum, String address, String email,
			String post, String salesman) {
		// TODO Auto-generated method stub
		return client.updClient(ID, kind, name, level, phoneNum, address, email, post, salesman);
	}

}
