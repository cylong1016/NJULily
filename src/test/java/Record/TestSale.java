package Record;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.commodity.CommodityVO;
import vo.sale.SalesVO;
import blservice.saleblservice.SaleShowBLService;
import businesslogic.commoditybl.Commodity;
import businesslogic.recordbl.SaleDetailListItem;
import businesslogic.salebl.SaleInfo;
import businesslogic.salebl.SaleShowController;
import config.RMIConfig;
import dataenum.BillType;
import dataservice.saledataservice.SaleInfoService;

public class TestSale {

	@Test
	public void test() throws MalformedURLException, RemoteException, NotBoundException {
//		SaleDetailListItem item = new SaleDetailListItem("SP-002-003-004-00001", commodityName)
		Commodity commodity = new Commodity();
		ArrayList<CommodityVO > vos = commodity.show();
		for (CommodityVO vo : vos ) {
			System.out.println(vo.ID + " " + vo.name + " " + vo.type);
		}
	}

}
