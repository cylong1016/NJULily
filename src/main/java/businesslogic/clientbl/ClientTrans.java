package businesslogic.clientbl;

import java.util.ArrayList;

import po.ClientPO;
import vo.client.ClientAddVO;
import vo.client.ClientPartInfoVO;
import vo.client.ClientVO;
import dataenum.ClientCategory;
import dataenum.ClientLevel;

public class ClientTrans {
	
	/**
	 * 将全部的ClientPO转化成ClientVO
	 * @param clientsPO ArrayList<ClientPO>
	 * @return ArrayList<ClientVO>
	 * @author cylong
	 * @version 2014年11月29日 下午4:31:51
	 */
	public ArrayList<ClientVO> posToVOs(ArrayList<ClientPO> clientsPO) {
		ArrayList<ClientVO> clientsVO = new ArrayList<ClientVO>();
		for(ClientPO po : clientsPO) {
			clientsVO.add(poToVO(po));
		}
		return clientsVO;
	}
	
	/**
	 * 将一个ClientPO转化成VO
	 * @param po ClientPO
	 * @return ClientVO
	 * @author cylong
	 * @version 2014年11月29日 下午4:37:21
	 */
	public ClientVO poToVO(ClientPO po) {
		String ID = po.getID();
		ClientCategory category = po.getCategory();
		ClientLevel level = po.getLevel();
		String name = po.getName();
		String phone = po.getPhone();
		String address = po.getAddress();
		String post = po.getPost();
		String email = po.getEmail();
		double receivable = po.getReceivable();
		double payable = po.getPayable();
		double receivableLimit = po.getReceivableLimit();
		String salesman = po.getSalesman();
		ClientVO vo = new ClientVO(ID, category, level, name, phone, address, post, email, receivable, payable, receivableLimit, salesman);
		return vo;
	}

	public ClientPO voToPO(ClientAddVO vo) {
		String ID = vo.ID;
		ClientCategory category = vo.category;
		ClientLevel level = vo.level;
		String name = vo.name;
		String phone = vo.phone;
		String address = vo.address;
		String post = vo.post;
		String email = vo.email;
		double receivableLimit = vo.receivableLimit;
		String salesman = vo.salesman;
		ClientPO po = new ClientPO(ID, category, level, name, phone, address, post, email, receivableLimit, salesman);
		return po;
	}

	/**
	 * 将全部的clientPO转为显示部分信息的clientPartInfoVO
	 * @param clientPOs
	 * @return
	 * @author Zing
	 * @version Dec 6, 2014 5:34:38 PM
	 */
	public ArrayList<ClientPartInfoVO> partPOstoVOs(ArrayList<ClientPO> clientPOs) {
		ArrayList<ClientPartInfoVO> VOs = new ArrayList<ClientPartInfoVO>();
		for (ClientPO po : clientPOs) {
			VOs.add(partPOtoVO(po.getID(), po.getName(), po.getSalesman(),po.getLevel(),po.getCategory(), po.getReceivable(), po.getPayable(), po.getReceivableLimit()));
		}
		return VOs;
	}

	/**
	 * 转化部分的信息
	 * @return
	 * @author Zing
	 * @version Dec 6, 2014 5:41:18 PM
	 */
	private ClientPartInfoVO partPOtoVO(String ID, String name,
			String salesman, ClientLevel level, ClientCategory category,
			double receivable, double payable, double receivableLimit) {
		return new ClientPartInfoVO(ID, category, level, name, salesman, receivable, payable, receivableLimit);
	}

}
