package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.InventoryBillVO;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.promotionbl.info.InventoryInfo_Promotion;
import config.RMIConfig;
import dataenum.PromotionType;
import dataservice.promotiondataservice.PromotionDataService;

/**
 * 策略1:制定一个特价包
 * 策略2:根据客户等级，制定赠送包/折扣/代金券
 * 策略3:根据购买的商品，制定赠送包／折扣／代金券
 * 策略4:根据购买的商品总价，制定折扣／赠送赠品／代金券
 * @author Zing
 * @version Nov 30, 2014 12:53:47 AM
 */
public class Promotion {

	/** 策略编号 */
	protected String ID;
	/** 促销起始时间 */
	protected String beginDate;
	/** 促销结束时间 */
	protected String endDate;
	/** 策略类型 */
	protected PromotionType type;
	// 数据
	protected PromotionDataService promotionData;
	/** 策略条目 */
	protected PromotionList list;

	public Promotion() {
		list = new PromotionList();
		promotionData = getPromotionData();
	}

	/**
	 * 得到销售策略的数据层
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:22 AM
	 */
	protected PromotionDataService getPromotionData() {
		try {
			return (PromotionDataService)Naming.lookup(RMIConfig.PREFIX + PromotionDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查看已经有的赠送单，帮助总经理制定销售策略
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:32 AM
	 * @throws RemoteException 
	 */
	public ArrayList<InventoryBillVO> showGifts() throws RemoteException {
		InventoryInfo_Promotion info = new InventoryInfo();
		return info.getGifts();
	}

	/**
	 * 制定销售策略前，UI调用方法得到ID
	 * @param type
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:35 AM
	 * @throws RemoteException 
	 */
	public String getID() throws RemoteException {
		this.ID = getPromotionData().getID();
		return ID;
	}
}
