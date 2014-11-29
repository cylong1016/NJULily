package businesslogic.clientbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.ClientVO;
import blservice.clientblservice.ClientBLService;
import dataenum.FindTypeClient;

/**
 * 客户的属性有：
 * 编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、
 * 姓名、电话、地址、邮编、电子邮箱、
 * 应收额度（允许客户欠款的上限，即客户最多可以欠本公司多少钱。取决于该客户的等级，可以为每个等级设置一个默认应收额度。）、
 * 应收、应付、默认业务员。应收应付不可修改，此数据项取决于进货单和销售单，收款单和付款单。
 * 应收额度仅最高权限可修改（ 销售人员可以创建客户，客户的默认应收额度由客户所在的级别决定 ）。
 * 客户的增删改查包括增加客户、删除客户、修改客户属性和查询客户。客户的查询可以通过输入关键字、客户编号等进行模糊查找。
 * @see blservice.clientblservice.ClientBLService
 * @author Zing
 * @version 2014年11月8日下午9:36:26
 */
public class ClientController implements ClientBLService {

	private Client client;

	/**
	 * @author cylong
	 * @version 2014年11月29日 下午3:25:25
	 */
	public ClientController() {
		client = new Client();
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#getID()
	 */
	@Override
	public String getID() {
		return client.getID();
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#show()
	 */
	@Override
	public ArrayList<ClientVO> show() {
		return client.show();
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#findClient(java.lang.String, dataenum.FindTypeClient)
	 */
	@Override
	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type) {
		return client.findClient(keywords, type);
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#addClient(vo.ClientVO)
	 */
	@Override
	public ResultMessage addClient(ClientVO vo) {
		return client.addClient(vo);
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#updClient(vo.ClientVO)
	 */
	@Override
	public ResultMessage updClient(ClientVO vo) {
		return client.updClient(vo);
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#deletClient(java.lang.String)
	 */
	@Override
	public ResultMessage deletClient(String ID) {
		return client.deletClient(ID);
	}

}
