package businesslogic.clientbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import vo.client.ClientAddVO;
import vo.client.ClientPartInfoVO;
import vo.client.ClientVO;
import dataenum.FindTypeClient;
import blservice.clientblservice.ClientBLService;

/**
 * @see blservice.clientblservice.ClientBLService
 * @author cylong
 * @version 2014年12月14日 上午8:21:29
 */
public class ClientController implements ClientBLService {

	private Client client;

	public ClientController() {
		try {
			client = new Client();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#getID()
	 */
	@Override
	public String getID() {
		try {
			return client.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#show()
	 */
	@Override
	public ArrayList<ClientVO> show() {
		try {
			return client.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#showPart()
	 */
	@Override
	public ArrayList<ClientPartInfoVO> showPart() {
		try {
			return client.showPart();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#findClient(java.lang.String, dataenum.FindTypeClient)
	 */
	@Override
	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type) {
		try {
			return client.findClient(keywords, type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#findClient(java.lang.String)
	 */
	@Override
	public ClientVO findClient(String ID) {
		try {
			return client.findClient(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#addClient(vo.client.ClientAddVO)
	 */
	@Override
	public ResultMessage addClient(ClientAddVO vo) {
		try {
			return client.addClient(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#updClient(vo.client.ClientAddVO)
	 */
	@Override
	public ResultMessage updClient(ClientAddVO vo) {
		try {
			return client.updClient(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.clientblservice.ClientBLService#deletClient(java.lang.String)
	 */
	@Override
	public ResultMessage deletClient(String ID) {
		try {
			return client.deletClient(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
