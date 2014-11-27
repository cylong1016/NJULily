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

	private  ArrayList<CommoditySortPO> children;

	private ArrayList<CommodityPO> commodities;

	public CommoditySortPO(String ID, String name, CommoditySortPO father) {
		super(ID);
		this.name = name;
		this.father = father;
	}


	public String getName() {
		return name;
	}

	public CommoditySortPO getFather() {
		return father;
	}

	public ArrayList<CommoditySortPO> getChildren() {
		return children;
	}

	public ArrayList<CommodityPO> getCommodities() {
		return commodities;
	}

}
