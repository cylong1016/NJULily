package Sale;

import java.util.ArrayList;

import org.junit.Test;

import dataenum.Storage;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionClientVO;
import vo.sale.SalesVO;
import vo.sale.saleAddVO;
import blservice.saleblservice.SaleBLService;
import businesslogic.salebl.SaleController;

public class TestPromotion {

	@Test
	public void test() {
		SaleBLService bl = new SaleController();
		bl.getSaleID();
		CommodityItemVO item = new CommodityItemVO("SP-101-102-00001", 2, 100, null, "一个灯", "Saaa");
		bl.addCommodities(item);
		bl.addClient("KH00001");
		ArrayList<PromotionClientVO> pros = bl.findFitPromotionClient();
		double all = bl.setPromotion("CXCL00009");
		System.out.println(all);
		if (pros == null) {
			System.out.println("null");
		}
		else {
			for (PromotionClientVO vo : pros) {
				System.out.println(vo.ID);
			}
		}
		saleAddVO addVO = new saleAddVO(Storage.STORAGE_ONE, 0, 0, null);
		SalesVO finalVO = bl.submit(addVO);
		System.out.println(finalVO.afterPrice);
		
	}

}
