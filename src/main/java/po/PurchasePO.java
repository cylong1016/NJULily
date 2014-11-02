package po;

import java.util.ArrayList;

import dataenum.Storage;


/**
 * 进货单和进货退货单持久化对象
 * @author cylong
 * @version Oct 26, 2014  1:41:14 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月31日下午4:52:15
 */
public class PurchasePO extends DocumentPO{
	/** 单据编号 */
	private String id;	
	/** 客户 */
	private ClientPO client;
	/** 仓库 */
	private Storage storage;
	/** 操作员 */
	private UserPO user;	
	/** 商品列表清单 */
	private ArrayList<CommodityItemPO> commodities;
	/** 总额*/
	private int sumPrice;
	/** 备注 */
	private String remark;
	
	public PurchasePO(String ID, ClientPO client, UserPO user,  Storage storage, 
			ArrayList<CommodityItemPO> commodities, int sumPrice){
		this.id = ID;
		this.client = client;
		this.user = user;
		this.storage = storage;
		this.commodities = commodities;
		this.sumPrice = sumPrice;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ClientPO getClient() {
		return client;
	}
	public void setClient(ClientPO client) {
		this.client = client;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public UserPO getUser() {
		return user;
	}
	public void setUser(UserPO user) {
		this.user = user;
	}
	public ArrayList<CommodityItemPO> getCommodities() {
		return commodities;
	}
	public void setCommodities(ArrayList<CommodityItemPO> commodities) {
		this.commodities = commodities;
	}
	public int getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
