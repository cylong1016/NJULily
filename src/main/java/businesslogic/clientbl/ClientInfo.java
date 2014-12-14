package businesslogic.clientbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import po.ClientPO;
import vo.client.ClientVO;
import businesslogic.accountbillbl.info.ClientInfo_AccountBill;
import businesslogic.accountinitbl.info.ClientInfo_Init;
import businesslogic.promotionbl.info.ClientInfo_Promotion;
import businesslogic.purchasebl.info.ClientInfo_Purchase;
import businesslogic.salebl.info.ClientInfo_Sale;
import dataenum.ClientLevel;

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
	 * @throws RemoteException
	 * @see businesslogic.accountbillbl.info.ClientInfo_AccountBill#getAllClients()
	 */
	@Override
	public HashMap<String, String> getAllClients() throws RemoteException {
		ArrayList<ClientVO> clientsVO = client.show();
		HashMap<String, String> clients = new HashMap<String, String>();
		for(int i = 0; i < clientsVO.size(); i++) {
			ClientVO vo = clientsVO.get(i);
			clients.put(vo.ID, vo.name);
		}
		return clients;
	}

	/**
	 * @throws RemoteException
	 * @see businesslogic.salebl.info.ClientInfo_Sale#getSalesman(java.lang.String)
	 */
	@Override
	public String getSalesman(String ID) throws RemoteException {
		ClientVO vo = client.findClient(ID);
		return vo.salesman;
	}

	/**
	 * @see businesslogic.salebl.info.ClientInfo_Sale#getName(java.lang.String)
	 * @see businesslogic.purchasebl.info.ClientInfo_Purchase#getName(java.lang.String)
	 */
	public String getName(String ID) throws RemoteException {
		ClientVO vo = client.findClient(ID);
		return vo.name;
	}

	public ArrayList<ClientPO> getClientPOs() throws RemoteException {
		return client.getClientData().show();
	}

	public ArrayList<ClientVO> getClientVOs(ArrayList<ClientPO> POs) {
		ClientTrans transPOVO = new ClientTrans();
		return transPOVO.posToVOs(POs);
	}

	/**
	 * @see businesslogic.salebl.info.ClientInfo_Sale#changeReceivable(java.lang.String, double)
	 */
	public void changeReceivable(String clientID, double afterPrice) throws RemoteException {
		ClientPO po = client.getClientData().find(clientID);
		po.setReceivable(po.getReceivable() + afterPrice);
		client.getClientData().update(po);
	}

	/**
	 * @see businesslogic.accountbillbl.info.ClientInfo_AccountBill#changePayable(java.lang.String, double)
	 * @see businesslogic.purchasebl.info.ClientInfo_Purchase#changePayable(java.lang.String, double)
	 */
	public void changePayable(String clientID, double beforePrice) throws RemoteException {
		ClientPO po = client.getClientData().find(clientID);
		po.setPayable(po.getPayable() + beforePrice);
		client.getClientData().update(po);
	}

	/**
	 * @see businesslogic.promotionbl.info.ClientInfo_Promotion#getLevel(java.lang.String)
	 */
	public ClientLevel getLevel(String clientID) throws RemoteException {
		return client.getClientData().find(clientID).getLevel();
	}
}
