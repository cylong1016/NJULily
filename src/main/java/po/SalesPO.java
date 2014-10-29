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
public class SalesPO {
	/** 单据编号 */
	public String id;
	
	/** 客户 */
	public ClientPO client;
	
	/** 仓库 */
	public Storage storage;
	
	/** 业务员（当前用户） */
	public UserPO user;	
	
	/** 商品列表清单 */
	public ArrayList<CommodityPO> commodities;
	
	/** 备注 */
	public String remark;
	
	/** 折让前总额*/
	public int beforePrice;
	
	/** 折让金额*/
	public int allowance;
	
	/** 代金券总额*/
	public int voucher;
	
	/** 折让后总额*/
	public int afterPrice;
	
	public SalesPO(){
		
	}

	
}
