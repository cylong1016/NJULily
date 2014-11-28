package businesslogic.salebl;


import java.util.ArrayList;

import vo.SalesVO;
import message.ResultMessage;
import dataenum.BillType;
import dataenum.Storage;
import businesslogicservice.SaleBLService;

public class SaleController implements SaleBLService {

	private Sale sale;
	
	public SaleController() {
		sale = new Sale();
	}
	
	/**
	 * @see businesslogicservice.SaleBLService#addCommodities(java.lang.String, int, double, java.lang.String)
	 */
	public void addCommodities(String ID, int number, double price,
			String remark) {
		sale.addCommodities(ID, number, price, remark);
	}

	/**
	 * @see businesslogicservice.SaleBLService#show()
	 */
	public ArrayList<SalesVO> show() {
		return sale.show();
	}

	/**
	 * @see businesslogicservice.SaleBLService#getID(dataenum.BillType)
	 */
	public String getID(BillType type) {
		return sale.getID(type);
	}

	/**
	 * @see businesslogicservice.SaleBLService#submit(java.lang.String, dataenum.Storage, double, double, java.lang.String)
	 */
	public ResultMessage submit(String clientID, Storage storage, double allowance, double voucher, String remark) {
		return sale.submit(clientID, storage, allowance, voucher, remark);
	}

	/**
	 * @see businesslogicservice.SaleBLService#save(java.lang.String, dataenum.Storage, double, double, java.lang.String)
	 */
	public ResultMessage save(String clientID, Storage storage, double allowance,
			double voucher, String remark) {
		return sale.save(clientID, storage, allowance, voucher, remark);
	}

}
