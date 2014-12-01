package vo;

import java.util.ArrayList;

/**
 * 商品分类值对象
 * @author cylong
 * @version Oct 26, 2014 2:25:58 PM
 */
/**
 * @author Zing
 * @version 2014年11月2日下午4:15:31
 */
public class CommoditySortVO extends ValueObject {
	
	public String ID;

	public String name;

	public String fatherID;

	public ArrayList<String> childrenID;
	
	public ArrayList<String> commoditiesID;

	public CommoditySortVO(String ID, String name, String fatherID, ArrayList<String> childrenID, ArrayList<String> commoditiesID) {
		this.name = name;
		this.ID = ID;
		this.fatherID = fatherID;
		this.childrenID = childrenID;
		this.commoditiesID = commoditiesID;
	}
}
