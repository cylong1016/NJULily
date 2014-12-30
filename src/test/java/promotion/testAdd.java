package promotion;


import org.junit.Test;

import dataenum.ClientLevel;
import blservice.promotionblservice.PromoInputInfo;
import blservice.promotionblservice.PromotionClientBLService;
import businesslogic.promotionbl.type.PromotionClientController;

public class testAdd {

	@Test
	public void test() {
		PromotionClientBLService pro = new PromotionClientController();
		pro.getID();
		pro.setClient(ClientLevel.LEVEL_1);
		PromoInputInfo info = new PromoInputInfo("20140101", "20150101", 0.9, 0);
		pro.submit(info);
	}

}
