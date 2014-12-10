package businesslogic.clientbl;

import java.util.ArrayList;

import message.ResultMessage;
import po.ClientPO;
import server.data.clientdata.ClientData;
import vo.client.ClientAddVO;
import vo.client.ClientPartInfoVO;
import vo.client.ClientVO;
import blservice.clientblservice.ClientBLService;
import businesslogic.userbl.UserInfo;
import dataenum.FindTypeClient;
import dataservice.clientdataservice.ClientDataService;

public class Client implements ClientBLService {

	private ClientDataService clientData;

	private ClientTrans transPOVO;

	/**
	 * @author cylong
	 * @version 2014年11月29日 下午3:26:27
	 */
	public Client() {
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			this.clientData = factory.getClientData();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		clientData = new ClientData();
	}

	/**
	 * @return 创建客户时候的新ID
	 * @author cylong
	 * @version 2014年11月29日 下午4:47:04
	 */
	public String getID() {
		return clientData.getID();
	}

	/**
	 * 返回全部的客户
	 * @author cylong
	 * @version 2014年11月29日 下午4:10:31
	 */
	public ArrayList<ClientVO> show() {
		transPOVO = new ClientTrans();
		ArrayList<ClientPO> clientsPO = clientData.show();
		ArrayList<ClientVO> clientsVO = transPOVO.posToVOs(clientsPO);
		return clientsVO;
	}

	/**
	 * 显示全部客户的部分信息（给需要添加客户的界面使用)
	 */
	public ArrayList<ClientPartInfoVO> showPart() {
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
	 */
	public ArrayList<ClientVO> findClient(String keywords, FindTypeClient type) {
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
	 */
	public ClientVO findClient(String ID) {
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
	 */
	public ResultMessage addClient(ClientAddVO vo) {
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
	 */
	public ResultMessage updClient(ClientAddVO vo) {
		UserInfo_Client userInfo = new UserInfo();
		ClientPO po = clientData.find(vo.ID);	// 从数据层获得相应的client
		po.setCategory(vo.category);
		po.setLevel(vo.level);
		po.setName(vo.name);
		po.setPhone(vo.phone);
		po.setAddress(vo.address);
		po.setPost(vo.post);
		po.setEmail(vo.email);
		if (vo.receivableLimit != po.getReceivableLimit()) {	// 仅最高权限可以修改
			boolean b = po.setReceivableLimit(vo.receivableLimit, userInfo.getUserIden());
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
	 */
	public ResultMessage deletClient(String ID) {
		return clientData.delete(ID);
	}

	public ClientDataService getClientData() {
		return clientData;
	}

}
