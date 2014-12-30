package Sale;

import java.util.ArrayList;

import org.junit.Test;

import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionTotalVO;
import blservice.saleblservice.SaleBLService;
import businesslogic.salebl.SaleController;

public class TestClientPro {

	@Test
	public void test() {
		SaleBLService bl = new SaleController();
		bl.getSaleID();
		CommodityItemVO item = new CommodityItemVO("SP-101-102-00001", 2, 100, null, "一个灯", "Saaa");
		bl.addCommodities(item);
		bl.addClient("KH00001");
		ArrayList<PromotionTotalVO> tots = bl.findFitPromotionTotal();
		double all = bl.setPromotion("CXCL00010");
		System.out.println(all);
		if (tots == null) {
			System.out.println("null");
		}
		else {
			for (PromotionTotalVO vo : tots) {
				System.out.println(vo.ID);
			}
		}
	}

}
