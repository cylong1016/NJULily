package businesslogic.accountainitbl;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import businesslogic.accountainitbl.info.AccountInfo_Init;
import businesslogic.accountainitbl.info.ClientInfo_Init;
import businesslogic.accountainitbl.info.CommodityInfo_Init;
import businesslogic.accountainitbl.info.CommoditySortInfo_Init;
import businesslogic.accountbl.AccountInfo;
import businesslogic.clientbl.ClientInfo;
import businesslogic.commoditybl.CommodityInfo;
import businesslogic.commoditysortbl.CommoditySortInfo;
import po.AccountPO;
import po.AccountaInitPO;
import po.ClientPO;
import po.CommodityPO;
import po.CommoditySortPO;
import config.RMI;
import dataservice.DataFactoryService;
import dataservice.accountinitdataservice.AccountaInitDataService;
import message.ResultMessage;
import vo.AccountVO;
import vo.AccountaInitVO;
import vo.ClientVO;
import vo.CommoditySortVO;
import vo.CommodityVO;
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
public class Accountainit {
	
	private AccountaInitDataService accountaInitData;
	
	public Accountainit() {
		this.accountaInitData = getAccountaInitData();
	}
	
	/**
	 * 期初建账
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 8:15:55 PM
	 */
	public ResultMessage buildAccount() {
		BuildInit buildInit = new BuildInit(getID());
		AccountaInitPO po = new AccountaInitPO(buildInit.getID(), buildInit.getDate(), buildInit.getCommoditySorts(), 
				buildInit.getCommodities(), buildInit.getClients(), buildInit.getAccounts());
		return accountaInitData.insert(po);
	}

	public ArrayList<AccountaInitVO> show() {
		ArrayList<AccountaInitPO> POs = accountaInitData.show();
		ArrayList<AccountaInitVO> VOs = new ArrayList<AccountaInitVO>();
		for (AccountaInitPO po : POs) {
			AccountaInitVO vo = new AccountaInitVO(po.getID(), po.getDate(), getSortVOs(po.getCommoditySorts()), 
					getCommodityVOs(po.getCommodities()), getClientVOs(po.getClients()), getAccountVOs(po.getAccounts()));
			VOs.add(vo);
		}
		return VOs;
	}
	
	/** 以下的方法是为了转换每一个PO，变成VO展示 */
	private ArrayList<CommoditySortVO> getSortVOs(ArrayList<CommoditySortPO> POs){
		CommoditySortInfo_Init info = new CommoditySortInfo();
		return info.getSortVOs(POs);
	}
	
	private ArrayList<CommodityVO> getCommodityVOs(ArrayList<CommodityPO> POs){
		CommodityInfo_Init info = new CommodityInfo();
		return info.getCommodityVOs(POs);
	}
	
	private ArrayList<ClientVO> getClientVOs(ArrayList<ClientPO> POs){
		ClientInfo_Init info = new ClientInfo();
		return info.getClientVOs(POs);
	}
	
	private ArrayList<AccountVO> getAccountVOs(ArrayList<AccountPO> POs){
		AccountInfo_Init info = new AccountInfo();
		return info.getAccountVOs(POs);
	}
	
	private String getID(){
		return accountaInitData.getID();
	}
	/**
	 * 得到期初建账的数据
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 7:35:59 PM
	 */
	private AccountaInitDataService getAccountaInitData() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			AccountaInitDataService accountaInitData = factory.getAccountaInitData();
			return accountaInitData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
