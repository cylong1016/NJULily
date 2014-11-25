package server.data;

import java.util.ArrayList;

import message.ResultMessage;
import po.ClientPO;
import server.common.Common;
import server.io.DefineList;
import dataenum.FindTypeClient;
import dataservice.ClientDataService;

/**
 * @author cylong
 * @version Nov 11, 2014 7:47:51 PM
 */
public class ClientData implements ClientDataService {

	private DefineList<ClientPO> clientList;
	private String filePath = "data/ClientList";
	private String currentID;
	private static final String INIT_CLIENT_ID = "10000";
	public ClientData() {
		init();
	}
	/**
	 * @see dataservice.DataService#init()
	 */
	public void init() {
		clientList = new DefineList<ClientPO>(filePath);
	}

	/**
	 * @see dataservice.DataService#getID()
	 */
	public String getID() {
		if(clientList.size() == 0) {
			return INIT_CLIENT_ID; // 客户初始id
		}
		currentID = clientList.get(clientList.size() - 1).getID();
		long id = Long.parseLong(currentID);
		currentID = String.valueOf(id + 1);
		return currentID;
	}

	/**
	 * @see dataservice.ClientDataService#insert(po.ClientPO)
	 */
	public ResultMessage insert(ClientPO po) {
		for(int i = 0; i < clientList.size(); i++) {
			if(po.equals(clientList.get(i))) {
				return ResultMessage.FAILURE;
			}
		}
		clientList.add(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see dataservice.ClientDataService#delete(java.lang.String)
	 */
	public ResultMessage delete(String ID) {
		for(int i = 0; i < clientList.size(); i++) {
			if(clientList.get(i).getID().equals(ID)) {
				clientList.remove(i);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILURE;
	}

	/**
	 * @see dataservice.ClientDataService#update(po.ClientPO)
	 */
	public ResultMessage update(ClientPO po) {
		for(int i = 0; i < clientList.size(); i++) {
			if(clientList.get(i).equals(po)) {
				clientList.set(i, po);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILURE;
	}

	/**
	 * @see dataservice.ClientDataService#show()
	 */
	public ArrayList<ClientPO> show() {
		return clientList.getInnerList();
	}

	/**
	 * @see dataservice.ClientDataService#find(java.lang.String, dataenum.FindTypeClient)
	 */
	public ArrayList<ClientPO> find(String keywords, FindTypeClient type) {
		keywords = keywords.toLowerCase(); // 为了不区分大小写
		ArrayList<ClientPO> clients = new ArrayList<ClientPO>();
		switch(type) {
		case ID:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getID().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case ADDRESS:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getAddress().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case EMAIL:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getEmail().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case KIND:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getCategory().toString().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case LEVEL:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getLevel().toString().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case NAME:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getName().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case PAYABLE:
			for(ClientPO client : clientList.getInnerList()) {
				if(Double.toString(client.getPayable()).toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case PHONE:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getPhone().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case POST:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getPost().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case RECEIVABLE:
			for(ClientPO client : clientList.getInnerList()) {
				if(Double.toString(client.getReceivable()).toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case RECEIVABLELIMIT:
			for(ClientPO client : clientList.getInnerList()) {
				if(Double.toString(client.getReceivable()).toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case SALESMAN:
			for(ClientPO client : clientList.getInnerList()) {
				if(client.getSalesman().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		default:
			clients.addAll(find(keywords, FindTypeClient.ID));
			clients.addAll(find(keywords, FindTypeClient.ADDRESS));
			clients.addAll(find(keywords, FindTypeClient.KIND));
			clients.addAll(find(keywords, FindTypeClient.EMAIL));
			clients.addAll(find(keywords, FindTypeClient.LEVEL));
			clients.addAll(find(keywords, FindTypeClient.NAME));
			clients.addAll(find(keywords, FindTypeClient.PAYABLE));
			clients.addAll(find(keywords, FindTypeClient.PHONE));
			clients.addAll(find(keywords, FindTypeClient.POST));
			clients.addAll(find(keywords, FindTypeClient.RECEIVABLE));
			clients.addAll(find(keywords, FindTypeClient.RECEIVABLELIMIT));
			clients.addAll(find(keywords, FindTypeClient.SALESMAN));
			break;
		}
		// 删除List中重复的对象
		Common.deleteRep(clients);
		return clients;
	}

}
