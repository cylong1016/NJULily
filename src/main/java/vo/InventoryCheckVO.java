package vo;

import java.util.ArrayList;

/**
 * 库存盘点
 * 盘点的是当天的库存快照，包括当天的各种商品的名称，型号，库存数量，库存均价，批次，批号， 并且显示行号。
 * 要求可以导出Excel。盘点时，系统自动根据当前盘点时间生成一个截止点，这个点就是批次（日期）批号（序号），
 * 在这个截点之后做的交易是不计入盘点的。
 * 行号就是所有商品展示时的行号。
 * @author Zing
 * @version 2014年11月8日下午6:15:31
 */
public class InventoryCheckVO {
	/** 商品列表 */
	public ArrayList<CheckCommodityItemVO> commodities;
	/** 库存均价 */
	public double avePrice;
	/** 批号 */
	public String today;
	/** 批次 */
	public String lot;
	
	public InventoryCheckVO(ArrayList<CheckCommodityItemVO> commodities, double avePrice, String today, String lot) {
		this.commodities = commodities;
		this.avePrice =avePrice;
		this.today = today;
		this.lot = lot;
	}
	
	
	
	

}
