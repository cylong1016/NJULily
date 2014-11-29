package businesslogic.purchasebl;

import java.util.ArrayList;

import dataenum.Storage;
import po.CommodityItemPO;

public class PurchaseList {
	
	/** 客户 */
	private String clientID;
	/** 仓库 */
	private Storage storage;
	/** */
	private ArrayList<PurchaseListItem> commodities;
	/** */
	private double beforePrice;
	/** 备注 */
	private String remark;
	
	public PurchaseList() {
		commodities = new ArrayList<PurchaseListItem>();
		beforePrice = 0;
	}

	public void add(PurchaseListItem item){
		commodities.add(item);
	}
	
	public double getBeforePrice(){
		for (int i = 0; i < commodities.size(); i++) {
			beforePrice+=commodities.get(i).getTotal();
		}
		return beforePrice;
	}
	
	public ArrayList<CommodityItemPO> getCommodities() {
		ArrayList<CommodityItemPO> commoditiesPO = new ArrayList<CommodityItemPO>();
		for (int i = 0; i < commodities.size(); i++) {
			PurchaseListItem c = commodities.get(i);
			CommodityItemPO po = new CommodityItemPO(c.getID(), c.getNumber(), c.getPrice(), c.getTotal(), c.getRemark());
			commoditiesPO.add(po);
		}
		return commoditiesPO;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
