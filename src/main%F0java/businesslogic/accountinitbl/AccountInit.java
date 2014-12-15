package businesslogic.accountinitbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import po.AccountPO;
import po.AccountaInitPO;
import po.ClientPO;
import po.CommodityPO;
import po.CommoditySortPO;
import vo.AccountVO;
import vo.AccountaInitVO;
import vo.client.ClientVO;
import vo.commodity.CommoditySortVO;
import vo.commodity.CommodityVO;
import businesslogic.accountbl.AccountInfo;
import businesslogic.accountinitbl.info.AccountInfo_Init;
import businesslogic.accountinitbl.info.ClientInfo_Init;
import businesslogic.accountinitbl.info.CommodityInfo_Init;
import businesslogic.accountinitbl.info.CommoditySortInfo_Init;
import businesslogic.clientbl.ClientInfo;
import businesslogic.commoditybl.CommodityInfo;
import businesslogic.commoditysortbl.CommoditySortInfo;
import config.RMIConfig;
import dataservice.accountinitdataservice.AccountInitDataService;

/**
 * 这个系统是可以支持建多套账的，每套帐在新建的时候都要经过期初建账这一环节，可以理解为一套帐的初始化操作。
 * 包括：
 * 添加商品信息（商品分类，某一商品的名称，类别，型号，进价/售价(默认为上年平均)，最近进价和最近售价留空），
 * 客户信息（客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)），
 * 银行账户信息（名称，余额）。
 * 期初的信息一旦建立完毕就会单独存储起来，同时将此信息作为系统的启动初始状态。
 * 之后的一切操作将会改变系统里的信息，但不会改变期初信息。期初信息随时可查。
 * @author Zing
 * @version Dec 2, 2014 7:09:40 PM
 */
public class AccountInit {

	private AccountInitDataService accountInitData;

	public AccountInit() {
		this.accountInitData = getAccountInitData();
	}

	/**
	 * 期初建账
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 8:15:55 PM
	 * @throws RemoteException 
	 */
	public ResultMessage buildAccount() throws RemoteException {
		BuildInit buildInit = new BuildInit(getID());
		AccountaInitPO po = new AccountaInitPO(buildInit.getID(), buildInit.getDate(), buildInit.getCommoditySorts(), buildInit.getCommodities(), buildInit.getClients(), buildInit.getAccounts());
		return accountInitData.insert(po);
	}

	public ArrayList<AccountaInitVO> show() throws RemoteException {
		ArrayList<AccountaInitPO> POs = accountInitData.show();
		ArrayList<AccountaInitVO> VOs = new ArrayList<AccountaInitVO>();
		for(AccountaInitPO po : POs) {
			AccountaInitVO vo =
								new AccountaInitVO(po.getID(), po.getDate(), getSortVOs(po.getCommoditySorts()), getCommodityVOs(po.getCommodities()), getClientVOs(po.getClients()), getAccountVOs(po.getAccounts()));
			VOs.add(vo);
		}
		return VOs;
	}

	/** 以下的方法是为了转换每一个PO，变成VO展示 */
	private ArrayList<CommoditySortVO> getSortVOs(ArrayList<CommoditySortPO> POs) {
		CommoditySortInfo_Init info = new CommoditySortInfo();
		return info.getSortVOs(POs);
	}

	private ArrayList<CommodityVO> getCommodityVOs(ArrayList<CommodityPO> POs) throws RemoteException {
		CommodityInfo_Init info = new CommodityInfo();
		return info.getCommodityVOs(POs);
	}

	private ArrayList<ClientVO> getClientVOs(ArrayList<ClientPO> POs) {
		ClientInfo_Init info = new ClientInfo();
		return info.getClientVOs(POs);
	}

	private ArrayList<AccountVO> getAccountVOs(ArrayList<AccountPO> POs) {
		AccountInfo_Init info = new AccountInfo();
		return info.getAccountVOs(POs);
	}

	private String getID() throws RemoteException {
		return accountInitData.getID();
	}

	/**
	 * 得到期初建账的数据
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 7:35:59 PM
	 */
	private AccountInitDataService getAccountInitData() {
		try {
			return (AccountInitDataService)Naming.lookup(RMIConfig.PREFIX + AccountInitDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
