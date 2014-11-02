package po;

import java.util.ArrayList;
import dataenum.Storage;


/**
 * 销售和销售退货单持久化对象
 * @author cylong
 * @version Oct 26, 2014  2:04:19 PM
 */
/**
 * 持久化对象就是销售单和销售退货单
 * @author Zing
 * @version 2014年10月29日上午9:48:18
 */
public class SalesPO extends DocumentPO{
	/** 单据编号 */
	private String id;	
	/** 客户 */
	private ClientPO client;
	/** 仓库 */
	private Storage storage;
	/** 业务员 */
	private UserPO salesman;
	/** 操作员 */
	private UserPO user;	
	/** 商品列表清单 */
	private ArrayList<CommodityItemPO> commodities;
	/** 折让前总额*/
	private int beforePrice;
	/** 折让金额*/
	private int allowance;
	/** 代金券总额*/
	private int voucher;
	/** 折让后总额*/
	private int afterPrice;
	/** 备注 */
	private String remark;
	
	
	public SalesPO(String ID, ClientPO client, UserPO salesman, UserPO user,  Storage storage, 
			ArrayList<CommodityItemPO> commodities, int beforePrice, int allowance, 
			int voucher, String remark , int afterPrice){
		this.id = ID;
		this.client = client;
		this.salesman = salesman;
		this.user = user;
		this.storage = storage;
		this.commodities = commodities;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.remark = remark;
		this.afterPrice = afterPrice;
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


	public UserPO getSalesman() {
		return salesman;
	}


	public void setSalesman(UserPO salesman) {
		this.salesman = salesman;
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


	public int getBeforePrice() {
		return beforePrice;
	}


	public void setBeforePrice(int beforePrice) {
		this.beforePrice = beforePrice;
	}


	public int getAllowance() {
		return allowance;
	}


	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}


	public int getVoucher() {
		return voucher;
	}


	public void setVoucher(int voucher) {
		this.voucher = voucher;
	}


	public int getAfterPrice() {
		return afterPrice;
	}


	public void setAfterPrice(int afterPrice) {
		this.afterPrice = afterPrice;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
