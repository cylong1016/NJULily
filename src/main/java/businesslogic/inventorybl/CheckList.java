package businesslogic.inventorybl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.CheckCommodityItemPO;
import businesslogic.commoditybl.Commodity;
import businesslogic.inventorybl.info.CommodityInfo;

/**
 * 库存盘点（盘点的是之前所有的库存快照，包括之前所有的各种商品的名称，型号，库存数量，库存均价，批次，批号， 并且显示行号。
 * 要求可以导出Excel。
 * 盘点时，系统自动根据当前盘点时间生成一个截止点，这个点就是批次（日期）批号（序号），
 * 在这个截点之后做的交易是不计入盘点的。行号就是所有商品展示时的行号。）
 * @author Zing
 * @version Nov 28, 201410:51:02 AM
 */
public class CheckList {
	/** 批号 */
	private String today;
	/** 批次 */
	private String lot;
	
	private ArrayList<CheckListItem> items;
	
	public CheckList(String lot) {
		this.lot = lot;
		today = addToday();
		items = addItems();
	}
		
	public String addToday(){
		String today = null;   
	    Date dt = new Date();   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    today = sdf.format(dt);   
	    return today;
	}
	
	public ArrayList<CheckListItem> addItems(){
		CommodityInfo info = new Commodity();
		ArrayList<String> IDs = info.getAllID();
		for (int i = 0; i < IDs.size(); i++) {
			CheckListItem item = new CheckListItem(IDs.get(i));
			items.add(item);
		}
		return items;
	}

	public String getToday() {
		return today;
	}

	public String getLot() {
		return lot;
	}

	public ArrayList<CheckCommodityItemPO> getItems() {
		ArrayList<CheckCommodityItemPO> pos = new ArrayList<CheckCommodityItemPO>(); 
		for (int i = 0; i < items.size(); i++) {
			CheckListItem item = items.get(i);
			CheckCommodityItemPO po = new CheckCommodityItemPO(item.getName(), item.getType(), item.getNumber(), item.getAvePrice());
			pos.add(po);
		}	
		return pos;
	}

	
}
