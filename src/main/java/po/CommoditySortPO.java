package po;


/**
 * 商品分类持久化对象
 * @author cylong
 * @version Oct 26, 2014  2:22:18 PM
 */
public class CommoditySortPO extends PersistentObject{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private CommoditySortPO father;
	
	private CommoditySortPO children;
	
	public CommoditySortPO(String ID, String name, CommoditySortPO father, CommoditySortPO children){
		super(ID);
		this.name = name;
		this.father = father;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CommoditySortPO getFather() {
		return father;
	}

	public void setFather(CommoditySortPO father) {
		this.father = father;
	}

	public CommoditySortPO getChildren() {
		return children;
	}

	public void setChildren(CommoditySortPO children) {
		this.children = children;
	}
	
	
}
