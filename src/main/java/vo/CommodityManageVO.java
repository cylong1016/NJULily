package vo;

/**
 * 商品分类值对象
 * @author cylong
 * @version Oct 26, 2014  2:25:58 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年11月2日下午4:15:31
 */
public class CommodityManageVO extends ValueObject{
	public String name;
	
	public CommodityManageVO father;
	
	public CommodityManageVO children;
	
	public CommodityManageVO(String ID, String name, CommodityManageVO father, CommodityManageVO children){
		super(ID, name);
		this.name = name;
		this.father = father;
		this.children = children;
	}
}
