package Record;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.sale.SalesVO;
import blservice.saleblservice.SaleBLService;
import blservice.saleblservice.SaleShowBLService;
import businesslogic.salebl.SaleController;
import businesslogic.salebl.SaleShowController;
import config.RMIConfig;
import dataenum.BillType;
import dataservice.saledataservice.SaleInfoService;

public class TestSale {

	@Test
	public void test() throws MalformedURLException, RemoteException, NotBoundException {
		SaleInfoService saleInfo = (SaleInfoService)Naming.lookup(RMIConfig.PREFIX + SaleInfoService.NAME);
		ArrayList<String> IDs = saleInfo.getAllID(BillType.SALE);
//		SaleShowBLService bl = new SaleShowController();
//		ArrayList<SalesVO> vos = bl.showSale();
//		for (SalesVO ID : vos) {
//			System.out.println(ID.ID);
//		}
		
	}

}
