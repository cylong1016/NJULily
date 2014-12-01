package server.data;

import java.util.ArrayList;

import po.ClientPO;
import server.common.ParseXML;
import server.io.DefineList;
import dataenum.FindTypeClient;
import dataservice.ClientDataService;

/**
 * @see dataservice.ClientDataService
 * @author cylong
 * @version Nov 11, 2014 7:47:51 PM
 */
public class ClientData extends CommonData<ClientPO> implements ClientDataService {

	/**
	 * @see dataservice.commondata.DataService#init()
	 */
	@Override
	public void init() {
		ParseXML parsexml = new ParseXML("ClientData");
		filePath = parsexml.getValue("path");
		initID = parsexml.getValue("initID");
		poList = new DefineList<ClientPO>(filePath);
	}

	/**
	 * @see dataservice.ClientDataService#find(java.lang.String, dataenum.FindTypeClient)
	 */
	@Override
	public ArrayList<ClientPO> find(String keywords, FindTypeClient type) {
		keywords = keywords.toLowerCase(); // 为了不区分大小写
		ArrayList<ClientPO> clients = new ArrayList<ClientPO>();
		if(type == null) {	// 查找客户全部信息
			for(ClientPO client : poList.getInList()) {
				if (client.toString().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			return clients;
		}
		switch(type) {
		case ID:
			for(ClientPO client : poList.getInList()) {
				if (client.getID().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case ADDRESS:
			for(ClientPO client : poList.getInList()) {
				if (client.getAddress().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case EMAIL:
			for(ClientPO client : poList.getInList()) {
				if (client.getEmail().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case KIND:
			for(ClientPO client : poList.getInList()) {
				if (client.getCategory().toString().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case LEVEL:
			for(ClientPO client : poList.getInList()) {
				if (client.getLevel().toString().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case NAME:
			for(ClientPO client : poList.getInList()) {
				if (client.getName().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case PAYABLE:
			for(ClientPO client : poList.getInList()) {
				if (Double.toString(client.getPayable()).toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case PHONE:
			for(ClientPO client : poList.getInList()) {
				if (client.getPhone().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case POST:
			for(ClientPO client : poList.getInList()) {
				if (client.getPost().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case RECEIVABLE:
			for(ClientPO client : poList.getInList()) {
				if (Double.toString(client.getReceivable()).toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case RECEIVABLELIMIT:
			for(ClientPO client : poList.getInList()) {
				if (Double.toString(client.getReceivable()).toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		case SALESMAN:
			for(ClientPO client : poList.getInList()) {
				if (client.getSalesman().toLowerCase().contains(keywords)) {
					clients.add(client);
				}
			}
			break;
		default:
			break;
		}
		return clients;
	}

}
