package dataenum;

// TODO　@Zing
// 不会写这个。。
public enum PromotionType {
	BARGAINS(""),
	CLIENT(""),
	COMMODITY(""),
	TOTAL("");
	
	public final String value;

	PromotionType(String value) {
		this.value = value;
	}
}
