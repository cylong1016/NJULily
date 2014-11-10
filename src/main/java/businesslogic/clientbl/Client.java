package businesslogic.clientbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.ClientVO;
import vo.UserVO;
import dataenum.ClientCategory;
import dataenum.ClientLevel;
import dataenum.FindTypeClient;

public class Client {
	/** 客户类别：进货商、销售商 */
	public ClientCategory category;
	/** 客户级别：1-5（vip） */
	public ClientLevel level;
	/** 客户姓名 */
	public String name;
	/** 客户电话 */
	public String phone;
	/** 客户地址 */
	public String address;
	/** 客户邮编 */
	public String post;
	/** 客户电子邮箱 */
	public String email;
	/** 客户应收 */
	public double receivable;
	/** 客户应付 */
	public double payable;
	/** 客户应收额度 */
	public double receivableLimit;
	/** 默认业务员 */
	public UserVO salesman;
	
	public ArrayList<ClientVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addClient(String kind, String name, String level,
			String phone, String address, String post, String email,
			UserVO salesman) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updClient(String ID, String kind, String name,
			String level, String phoneNum, String address, String email,
			String post, UserVO salesman) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deletClient(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
