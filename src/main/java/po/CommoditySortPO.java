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

	private String fatherID;

	private ArrayList<String> childrenID;

	private ArrayList<String> commoditiesID;

	public CommoditySortPO(String ID, String name, String fatherID, ArrayList<String> childrenID, ArrayList<String> commoditiesID) {
		super(ID);
		this.ID = ID;
		this.name = name;
		this.fatherID = fatherID;
		this.childrenID = childrenID;
		this.commoditiesID = commoditiesID;
	}

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return name;
	}

	public String getFatherID() {
		return fatherID;
	}

	public ArrayList<String> getChildrenID() {
		return childrenID;
	}

	public ArrayList<String> getCommoditiesID() {
		return commoditiesID;
	}

	public void addChildID(String childID) {
		if (childrenID == null) {
			childrenID = new ArrayList<String>();
		}
		this.childrenID.add(childID);
	}

	public void addCommodityID(String commodityID) {
		if (commoditiesID == null) {
			commoditiesID = new ArrayList<String>();
		}
		this.commoditiesID.add(commodityID);
	}

	public void removeCommodity(String ID) {
		for(int i = 0; i < commoditiesID.size(); i++) {
			if (ID == commoditiesID.get(i)) {
				commoditiesID.remove(i);
				return;
			}
		}
	}

}
