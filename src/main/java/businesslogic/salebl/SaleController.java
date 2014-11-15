package businesslogic.salebl;


import message.ResultMessage;
import dataenum.Storage;
import businesslogicservice.SaleBLService;

public class SaleController implements SaleBLService{

	private Sale sale;
	
	public SaleController() {
		sale = new Sale();
	}
	
	public void addCommodities(String name, int num, int price,
			String remark) {
		sale.addCommodities(name, num, price, remark);
	}


	public double getAfterPrice(double beforePrice, double allowance,
			double voucher) {
		// TODO Auto-generated method stub
		return sale.getAfterPrice(beforePrice, allowance, voucher);
	}

	public ResultMessage addSale(String client, String salesman,
			String user, Storage storage, double allowance, double voucher, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addSaleBack(String client,String salesman, String user, 
			Storage storage, double allowance, double voucher, String remark)  {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage submit() {
		// TODO Auto-generated method stub
		return null;
	}

}
