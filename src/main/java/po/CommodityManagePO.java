package po;


/**
 * 商品分类持久化对象
 * @author cylong
 * @version Oct 26, 2014  2:22:18 PM
 */
public class CommodityManagePO {
	private String name;
	
	private CommodityManagePO father;
	
	private CommodityManagePO children;
	
	public CommodityManagePO(String name, CommodityManagePO father, CommodityManagePO children){
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

	public CommodityManagePO getFather() {
		return father;
	}

	public void setFather(CommodityManagePO father) {
		this.father = father;
	}

	public CommodityManagePO getChildren() {
		return children;
	}

	public void setChildren(CommodityManagePO children) {
		this.children = children;
	}
	
	
}
