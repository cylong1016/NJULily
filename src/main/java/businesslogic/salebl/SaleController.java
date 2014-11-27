package businesslogic.salebl;


import java.util.ArrayList;

import vo.SalesVO;
import message.ResultMessage;
import dataenum.Storage;
import businesslogicservice.SaleBLService;

public class SaleController implements SaleBLService{

	private Sale sale;
	
	public SaleController() {
		sale = new Sale();
	}
	
	public void addCommodities(String name, int num, double price,
			String remark) {
		sale.addCommodities(name, num, price, remark);
	}


	public double getAfterPrice(double beforePrice, double allowance,
			double voucher) {
		return sale.getAfterPrice(beforePrice, allowance, voucher);
	}

	public ResultMessage addSale(String client, String salesman,
			String user, Storage storage, double allowance, double voucher, String remark) {
		return sale.addSale(client, salesman, user, storage, allowance, voucher, remark);
	}

	public ResultMessage addSaleBack(String client,String salesman, String user, 
			Storage storage, double allowance, double voucher, String remark)  {
		return sale.addSaleBack(client, salesman, user, storage, allowance, voucher, remark);
	}

	public ResultMessage submit() {
		return sale.submit();
	}

	public ArrayList<SalesVO> show() {
		return sale.show();
	}

}
