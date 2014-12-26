package businesslogic.clientbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import po.ClientPO;
import vo.client.ClientAddVO;
import vo.client.ClientPartInfoVO;
import vo.client.ClientVO;
import businesslogic.userbl.UserInfo;
import config.RMIConfig;
import dataenum.FindTypeClient;
import dataservice.clientdataservice.ClientDataService;

public class Client {

	private ClientDataService clientData;

	private ClientTrans transPOVO;

	/**
	 * @author cylong
	 * @version 2014年11月29日 下午3:26:27
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public Client() {
		try {
			clientData = (ClientDataService)Naming.lookup(RMIConfig.PREFIX + ClientDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return 创建客户时候的新ID
	 * @author cylong
	 * @version 2014年11月29日 下午4:47:04
	 * @throws RemoteException
	 */
	public String getID() throws RemoteException {
		return clientData.getID();
	}

	/**
	 * 返回全部的客户
	 * @author cylong
	 * @version 2014年11月29日 下午4:10:31
	 * @throws RemoteException
	 */
	public ArrayList<ClientVO> show() throws RemoteException {
		transPOVO = new ClientTrans();
		ArrayList<ClientPO> clientsPO = clientData.show();
		ArrayList<ClientVO> clientsVO = transPOVO.posToVOs(clientsPO);
		return clientsVO;
	}

	/**
	 * 显示全部客户的部分信息（给需要添加客户的界面使用)
	 * @throws RemoteException
	 */
	public ArrayList<ClientPartInfoVO> showPart() throws RemoteException {
		transPOVO = new ClientTrans();
		ArrayList<ClientPO> clientPOs = clientData.show();
		ArrayList<ClientPartInfoVO> clientVOs = transPOVO.partPOstoVOs(clientPOs);
		return clientVOs;
	}

	/**
	 * 模糊查找客户
	 * @param keywords 关键字
	 * @param type 查找类型
	 * @return 满足条件的客户
	 * @author cylong
	 * @version 2014年11月29日 下午4:29:04
	 * @throws RemoteException
	 */
	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type) throws RemoteException {
		transPOVO = new ClientTrans();
		ArrayList<ClientPO> clientsPO = clientData.find(keywords, type);
		ArrayList<ClientVO> clientsVO = transPOVO.posToVOs(clientsPO);
		return clientsVO;
	}

	/**
	 * 以ID精确查找客户
	 * @param ID 客户ID
	 * @return ClientVO
	 * @author cylong
	 * @version 2014年12月1日 下午2:55:47
	 * @throws RemoteException
	 */
	public ClientVO findClient(String ID) throws RemoteException {
		transPOVO = new ClientTrans();
		ClientPO po = clientData.find(ID);
		return transPOVO.poToVO(po);
	}

	/**
	 * 添加一位客户
	 * @param vo ClientVO
	 * @return
	 * @author cylong
	 * @version 2014年11月29日 下午4:35:22
	 * @throws RemoteException
	 */
	public ResultMessage addClient(ClientAddVO vo) throws RemoteException {
		transPOVO = new ClientTrans();
		ClientPO po = transPOVO.voToPO(vo);
		return clientData.insert(po);
	}

	/**
	 * 更新客户信息
	 * @param vo ClientVO
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月29日 下午4:49:10
	 * @throws RemoteException
	 */
	public ResultMessage updClient(ClientAddVO vo) throws RemoteException {
		ClientPO po = clientData.find(vo.ID);	// 从数据层获得相应的client
		po.setCategory(vo.category);
		po.setLevel(vo.level);
		po.setName(vo.name);
		po.setPhone(vo.phone);
		po.setAddress(vo.address);
		po.setPost(vo.post);
		po.setEmail(vo.email);
		if (vo.receivableLimit != po.getReceivableLimit()) {	// 仅最高权限可以修改
			boolean b = po.setReceivableLimit(vo.receivableLimit, UserInfo.getUserIden());
			if (!b) {
				return ResultMessage.FAILURE;	// 权限不够，更新失败
			}
		}
		po.setSalesman(vo.salesman);
		return clientData.update(po);
	}

	/**
	 * 以客户ID删除客户
	 * @param ID
	 * @return
	 * @author cylong
	 * @version 2014年11月29日 下午5:17:16
	 * @throws RemoteException
	 */
	public ResultMessage deletClient(String ID) throws RemoteException {
		return clientData.delete(ID);
	}

	public ClientDataService getClientData() {
		return clientData;
	}

}
