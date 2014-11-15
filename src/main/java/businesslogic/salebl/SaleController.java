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
		
		sale.addSale(client, salesman, user, storage, allowance, voucher, remark);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addSaleBack(String client,String salesman, String user, 
			Storage storage, double allowance, double voucher, String remark)  {
		
		sale.addSaleBack(client, salesman, user, storage, allowance, voucher, remark);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage submit() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SalesVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

}
