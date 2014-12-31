package businesslogic.clientbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogMsgController;
import vo.client.ClientAddVO;
import vo.client.ClientPartInfoVO;
import vo.client.ClientVO;
import blservice.clientblservice.ClientBLService;
import dataenum.FindTypeClient;
import dataenum.ResultMessage;

/**
 * @see blservice.clientblservice.ClientBLService
 * @author cylong
 * @version 2014年12月14日 上午8:21:29
 */
public class ClientController implements ClientBLService {

	private Client client;

	public ClientController() {
		client = new Client();
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
			LogMsgController.addLog("模糊查找客户 [关键字=" + keywords + "]");
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
	//		LogMsgController.addLog("精确查找客户 [客户ID=" + ID + "]");
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
			ResultMessage res = client.addClient(vo);
			if(res.equals(ResultMessage.SUCCESS)) {
				LogMsgController.addLog("添加客户 " + vo.toString());
			}
			return res;
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
			ResultMessage res = client.updClient(vo);
			if(res.equals(ResultMessage.SUCCESS)) {
				LogMsgController.addLog("更新客户 " + vo.toString());
			}
			return res;
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
			ResultMessage res = client.deletClient(ID);
			if(res.equals(ResultMessage.SUCCESS)) {
				LogMsgController.addLog("删除客户 [客户ID=" + ID + "]");
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
