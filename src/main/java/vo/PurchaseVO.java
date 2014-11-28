package vo;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.Storage;


/**
 * 进货单和进货退货单值对象
 * @author cylong
 * @version Oct 26, 2014  2:27:27 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月31日下午4:55:34
 */
public class PurchaseVO {
	
	/** 单据编号 */
	public String id;	
	/** 客户 */
	public ClientVO client;
	/** 仓库 */
	public Storage storage;
	/** 操作员 */
	public UserVO user;	
	/** 商品列表清单 */
	public ArrayList<CommodityItemVO> commodities;
	/** 总额*/
	public int sumPrice;
	/** 备注 */
	public String remark;
	/** 单据状态 */
	public BillState state;
	
	public PurchaseVO(String ID, ClientVO client, UserVO user,  Storage storage, 
			ArrayList<CommodityItemVO> commodities, int sumPrice, BillState state) {
		
		this.id = ID;
		this.client = client;
		this.user = user;
		this.storage = storage;
		this.commodities = commodities;
		this.sumPrice = sumPrice;
		this.state = state;
	}
}
