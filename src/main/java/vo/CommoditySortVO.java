package vo;

import java.util.ArrayList;

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
public class CommoditySortVO extends ValueObject{
	public String name;
	
	public CommoditySortVO father;
	
	public ArrayList<CommoditySortVO> children;
	
	public CommoditySortVO(String ID, String name, CommoditySortVO father, ArrayList<CommoditySortVO> children){
		super();
		this.name = name;
		this.father = father;
		this.children = children;
	}
}
