package dataenum;

public enum Storage {
	STORAGE_ONE("仓库1"),
	STORAGE_TWO("仓库2"),
	STORAGE_THREE("仓库3");
	
	public final String value;

	Storage(String value) {
		this.value = value;
	}
}
