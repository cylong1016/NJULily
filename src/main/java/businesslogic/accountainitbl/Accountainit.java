package businesslogic.accountainitbl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import dataservice.DataFactoryService;
import dataservice.accountinitdataservice.AccountaInitDataService;
import message.ResultMessage;
import vo.AccountaInitVO;
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
	
	private String date;
	
	private String ID;
	
	private AccountaInitDataService accountaInitData;
	
	public Accountainit() {
		this.accountaInitData = getAccountaInitData();
	}
	
	public ResultMessage buildAccount() {
		
		return null;
	}

	public ArrayList<AccountaInitVO> show() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getID(){
		return accountaInitData.getID();
	}
	
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
