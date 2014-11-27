package businesslogic.salebl;


import java.util.ArrayList;

import vo.SalesVO;
import message.ResultMessage;
import dataenum.BillType;
import dataenum.Storage;
import businesslogicservice.SaleBLService;

public class SaleController implements SaleBLService{

	private Sale sale;
	
	public SaleController() {
		sale = new Sale();
	}
	
	public void addCommodities(String ID, int number, double price,
			String remark) {
		sale.addCommodities(ID, number, price, remark);
	}

	public ArrayList<SalesVO> show() {
		return sale.show();
	}

	public String getID(BillType type) {
		return sale.getID(type);
	}

	public ResultMessage submit(String client, Storage storage, double allowance, double voucher, String remark) {
		return sale.submit(client, storage, allowance, voucher, remark);
	}

	public ResultMessage save(String client, Storage storage, double allowance,
			double voucher, String remark) {
		return sale.save(client, storage, allowance, voucher, remark);
	}

}
