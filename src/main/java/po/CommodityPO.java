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
	/** 商品分类ID */
	private String sortID;
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
	/** 商品警戒数量 */
	private int alarmNumber;
	
	/** 每次销售后计算平均售价 */
	private double aveSale;
	/** 每次进货后计算平均进价 */
	private double avePur;
	
	private int saleNumber;
	private int purNumber;
	/** 退货数量 */
	private int saleBackNumber;
	/** 能否被删除*/
	private boolean canDelete;

	/**
	 * @param ID 商品ID
	 * @param name 商品名称
	 * @param type 商品类型
	 * @param purPrice 商品默认进价
	 * @param salePrice 商品默认售价
	 * @author cylong
	 * @version Oct 26, 2014 1:21:03 PM
	 */
	public CommodityPO(String ID, String name, String sortID, String type, double purPrice, double salePrice, int alarmNumber) {
		super(ID);
		this.name = name;
		this.type = type;
		this.sortID = sortID;
		this.purPrice = purPrice;
		this.salePrice = salePrice;
		this.alarmNumber = alarmNumber;
		this.canDelete = true;
	}
	
	/**
	 * 期初建账的商品信息
	 * @param ID
	 * @param name
	 * @param type
	 * @param sortID
	 * @param aveSale
	 * @param avePur
	 */
	public CommodityPO(String ID, String name, String type, String sortID, double aveSale, double avePur) {
		super(ID);
		this.name = name;
		this.type = type;
		this.sortID = sortID;
		this.aveSale = aveSale;
		this.avePur = avePur;
	}

	/**
	 * 模糊查询的时候使用
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + type + inventoryNum + purPrice + salePrice + recentPurPrice + recentSalePrice + alarmNumber + ID;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommodityPO other = (CommodityPO)obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		if (this.type == null) {
			if (other.type != null)
				return false;
		} else if (!this.type.equals(other.type))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getSortID() {
		return sortID;
	}

	public int getInventoryNum() {
		return inventoryNum;
	}

	public double getPurPrice() {
		return purPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public double getRecentPurPrice() {
		return recentPurPrice;
	}

	public double getRecentSalePrice() {
		return recentSalePrice;
	}

	public int getAlarmNumber() {
		return alarmNumber;
	}

	public void setAlarmNumber(int alarmNumber) {
		this.alarmNumber = alarmNumber;
	}

	public double getAveSale() {
		return aveSale;
	}

	public void setAveSale(double aveSale) {
		this.aveSale = aveSale;
	}

	public double getAvePur() {
		return avePur;
	}

	public void setAvePur(double avePur) {
		this.avePur = avePur;
	}

	public void setRecentPurPrice(double recentPurPrice) {
		this.recentPurPrice = recentPurPrice;
	}

	public void setRecentSalePrice(double recentSalePrice) {
		this.recentSalePrice = recentSalePrice;
	}

	public int getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(int saleNumber) {
		this.saleNumber = saleNumber;
	}

	public int getPurNumber() {
		return purNumber;
	}

	public void setPurNumber(int purNumber) {
		this.purNumber = purNumber;
	}

	public void setInventoryNum(int inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	public int getSaleBackNumber() {
		return saleBackNumber;
	}

	public void setSaleBackNumber(int saleBackNumber) {
		this.saleBackNumber = saleBackNumber;
	}
	
}
