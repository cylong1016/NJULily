package dataenum;

public enum PromotionType {
	BARGAINS("特价包"),
	CLIENT("客户等级促销"),
	COMMODITY(""),
	TOTAL("购买总额促销");
	
	public final String value;

	PromotionType(String value) {
		this.value = value;
	}
}
