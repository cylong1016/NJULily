package vo;

import java.util.ArrayList;

import vo.commodity.CommodityItemVO;
import dataenum.BillState;
import dataenum.BillType;
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
public class PurchaseVO extends ValueObject{
	
	/** 单据编号 */
	public String ID;
	/** 客户ID */
	public String clientID;
	/** 客户 */
	public String client;
	/** 仓库 */
	public Storage storage;
	/** 操作员 */
	public String user;	
	/** 商品列表清单 */
	public ArrayList<CommodityItemVO> commodities;
	/** 总额*/
	public double beforePrice;
	/** 备注 */
	public String remark;
	public BillType type;
	/** 单据状态 */
	public BillState state;
	
	public PurchaseVO(BillType type, String ID, String clientID, String client, String user,  Storage storage, 
			ArrayList<CommodityItemVO> commodities, double beforePrice, BillState state) {
		this.type = type; 
		this.ID = ID;
		this.clientID = clientID;
		this.client = client;
		this.user = user;
		this.storage = storage;
		this.commodities = commodities;
		this.beforePrice = beforePrice;
		this.state = state;
	}
}
