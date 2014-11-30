package po;

import java.util.ArrayList;

public class InventoryCheckPO extends PersistentObject {

	private static final long serialVersionUID = 1L;
	/** 商品列表 */
	private ArrayList<CheckCommodityItemPO> commodities;
	/** 批号 */
	private String today;
	/** 批次 */
	private String lot;

	public InventoryCheckPO(ArrayList<CheckCommodityItemPO> commodities, String today, String lot) {
		super(lot);
		this.commodities = commodities;
		this.today = today;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<CheckCommodityItemPO> getCommodities() {
		return commodities;
	}

	public String getToday() {
		return today;
	}

	public String getLot() {
		return lot;
	}

}
