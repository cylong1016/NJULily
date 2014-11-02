package po;

/**
 * 商品持久化对象
 * @author cylong
 * @version Oct 26, 2014 12:59:30 PM
 */
public class CommodityPO extends PersistentObject {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 商品名称 */
	private String name;
	/** 商品型号 */
	private String type;
	/** 商品分类 */
	private CommodityManagePO sort;
	/** 商品库存数量 */
	private int inventoryNum;
	/** 商品进价 */
	private double purPrice;
	/** 商品售价 */
	private double salePrice;
	/** 商品最近进价 */
	private double recentPurPrice;
	/** 商品最近售价 */
	private double recentSalePrice;

	/**
	 * @param id 商品id
	 * @param name 商品名称
	 * @param type 商品类型
	 * @param purPrice 商品默认进价
	 * @param salePrice 商品默认售价
	 * @author cylong
	 * @version Oct 26, 2014 1:21:03 PM
	 */
	public CommodityPO(String id, String name, CommodityManagePO sort, String type, double purPrice, double salePrice) {
		super(id);
		this.name = name;
		this.type = type;
		this.sort = sort;
		this.purPrice = purPrice;
		this.salePrice = salePrice;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getInventoryNum() {
		return this.inventoryNum;
	}

	public void setInventoryNum(int inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	public double getPurPrice() {
		return this.purPrice;
	}

	public void setPurPrice(double purPrice) {
		this.purPrice = purPrice;
	}

	public double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getRecentPurPrice() {
		return this.recentPurPrice;
	}

	public void setRecentPurPrice(double recentPurPrice) {
		this.recentPurPrice = recentPurPrice;
	}

	public double getRecentSalePrice() {
		return this.recentSalePrice;
	}

	public void setRecentSalePrice(double recentSalePrice) {
		this.recentSalePrice = recentSalePrice;
	}

	public CommodityManagePO getSort() {
		return sort;
	}

	public void setSort(CommodityManagePO sort) {
		this.sort = sort;
	}

}
