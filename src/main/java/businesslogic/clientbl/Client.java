package businesslogic.clientbl;

import java.util.ArrayList;

import businesslogic.salebl.ClientInfo;
import message.ResultMessage;
import po.ClientPO;
import vo.ClientVO;
import dataenum.ClientCategory;
import dataenum.ClientLevel;
import dataenum.FindTypeClient;
import dataservice.ClientDataService;

public class Client implements businesslogic.accountbillbl.ClientInfo, ClientInfo{

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
	public String salesman;

	public ArrayList<ClientVO> clients;

	private ClientDataService clientData;

	private ClientPO po;

	public ArrayList<ClientVO> show() {
		// TODO 就for转换就可以了
		// clientData.show();
		return null;
	}

	/**
	 * 模糊查找
	 * @param keywords
	 * @param type
	 * @return
	 */
	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type) {
		// TODO 
		clientData.find(keywords, type);
		return null;
	}

	public ResultMessage addClient(ClientCategory category, String name, ClientLevel level, String phone, String address, String post, String email, double receivableLimit, String salesman) {
		po = new ClientPO(clientData.getID(), category, level, name, phone, address, post, email, receivableLimit, salesman);
		clientData.insert(po);
		return null;
	}

	public ResultMessage updClient(String ID, ClientCategory kind, String name, ClientLevel level, String phoneNum, String address, String email, String post, String salesman) {
		po = new ClientPO(ID, kind, level, name, phoneNum, address, post, email, receivableLimit, salesman);
		clientData.update(po);
		return null;
	}

	public ResultMessage deletClient(String ID) {
		return clientData.delete(ID);
	}

	/**
	 * @see businesslogic.accountbillbl.ClientInfo#getAllClients()
	 */
	public ArrayList<ClientPO> getAllClients() {
		return null;
	}

	/**
	 * @see bussinesslogic.salebl.ClientInfo#getClients
	 */
	public String getSalesman(String ID) {
		po = clientData.find(ID);
		return po.getSalesman();
	}

	public String getName(String ID) {
		po = clientData.find(ID);
		return po.getName();
	}

}
