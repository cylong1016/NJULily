package businesslogic.inventorybl.info;

import java.util.ArrayList;

public interface SaleInfo {
	
	public ArrayList<Double> getMoney(String begin, String end);
	
	public ArrayList<Integer> getNumber(String begin, String end);
}
