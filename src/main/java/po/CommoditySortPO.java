package po;

import java.util.ArrayList;

/**
 * 商品分类持久化对象
 * @author cylong
 * @version Oct 26, 2014 2:22:18 PM
 */
public class CommoditySortPO extends PersistentObject {

	private static final long serialVersionUID = 1L;

	private String name;

	private CommoditySortPO father;

	private CommoditySortPO children;

	private ArrayList<CommodityPO> commodities;

	public CommoditySortPO(String ID, String name, CommoditySortPO father) {
		super(ID);
		this.name = name;
		this.father = father;
		commodities = new ArrayList<CommodityPO>();
	}

	public void setChildren(CommoditySortPO children) {
		this.children = children;
	}

	public void addCommodity(CommodityPO po) {
		commodities.add(po);
	}

	public String getName() {
		return name;
	}

	public CommoditySortPO getFather() {
		return father;
	}

	public CommoditySortPO getChildren() {
		return children;
	}

}
