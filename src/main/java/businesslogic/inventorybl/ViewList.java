package businesslogic.inventorybl;

import java.util.ArrayList;

/**
 * 库存查看
 * 设定一个时间段，查看此时间段内的
 * 出/入库数量/金额，销售/进货的数量/金额（可以不显示销售/进货的数量/金额）。
 * 库存数量要有合计，这一点统一于普适需求。
 * @author Zing
 * @version Nov 28, 201412:27:57 AM
 */
public class ViewList {
	
	private String beginDate;
	
	private String endDate;
	
	private ArrayList<ViewListItem> items;
	
	public ViewList() {
	}
	
	public ViewList(String beginDate, String endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		items = new ArrayList<ViewListItem>();
	}
	
	
}
