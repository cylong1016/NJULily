package businesslogic.clientbl;

import java.util.ArrayList;
import java.util.HashMap;

import dataenum.ClientLevel;
import po.ClientPO;
import vo.client.ClientVO;
import businesslogic.accountainitbl.info.ClientInfo_Init;
import businesslogic.accountbillbl.info.ClientInfo_AccountBill;
import businesslogic.promotionbl.info.ClientInfo_Promotion;
import businesslogic.purchasebl.ClientInfo_Purchase;
import businesslogic.salebl.info.ClientInfo_Sale;

/**
 * 共外部获得Client信息
 * @author cylong
 * @version 2014年12月1日 下午2:49:21
 */
public class ClientInfo implements ClientInfo_AccountBill, ClientInfo_Sale, ClientInfo_Purchase, ClientInfo_Init, ClientInfo_Promotion {

	private Client client;
	
	public ClientInfo() {
		client = new Client();
	}
	/**
	 * @see businesslogic.accountbillbl.info.ClientInfo_AccountBill#getAllClients()
	 */
	@Override
	public HashMap<String, String> getAllClients() {
		ArrayList<ClientVO> clientsVO = client.show();
		HashMap<String, String> clients = new HashMap<String, String>();
		for(int i = 0; i < clientsVO.size(); i++) {
			ClientVO vo = clientsVO.get(i);
			clients.put(vo.ID, vo.name);
		}
		return clients;
	}

	/**
	 * @see businesslogic.salebl.ClientInfo_Purchase#getSalesman(java.lang.String)
	 */
	public String getSalesman(String ID) {
		ClientVO vo = client.findClient(ID);
		return vo.salesman;
	}

	/**
	 * @see businesslogic.salebl.ClientInfo_Purchase#getCommodityName(java.lang.String)
	 */
	public String getName(String ID) {
		ClientVO vo = client.findClient(ID);
		return vo.name;
	}
	
	public ArrayList<ClientPO> getClientPOs() {
		return client.getClientData().show();
	}
	public ArrayList<ClientVO> getClientVOs(ArrayList<ClientPO> POs) {
		ClientTrans transPOVO = new ClientTrans();
		return transPOVO.posToVOs(POs);
	}
	
	/*
	 * (non-Javadoc)
	 * @see businesslogic.accountbillbl.ClientInfo_AccountBill#changeReceivable(java.lang.String, double)
	 */
	public void changeReceivable(String clientID, double afterPrice) {
		ClientPO po = client.getClientData().find(clientID);
		po.setReceivable(po.getReceivable() + afterPrice);
		client.getClientData().update(po);
	}
	
	/*
	 * (non-Javadoc)
	 * @see businesslogic.accountbillbl.ClientInfo_AccountBill#changePayable(java.lang.String, double)
	 */
	public void changePayable(String clientID, double beforePrice) {
		ClientPO po = client.getClientData().find(clientID);
		po.setPayable(po.getPayable() + beforePrice);
		client.getClientData().update(po);
	}
	public ClientLevel getLevel(String clientID) {
		return client.getClientData().find(clientID).getLevel();
	}
}
