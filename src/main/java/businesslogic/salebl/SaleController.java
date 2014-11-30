package businesslogic.salebl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.CommodityItemVO;
import vo.ValueObject;
import blservice.saleblservice.SaleBLService;
import blservice.saleblservice.SaleInputInfo;
import dataenum.BillType;

/**
 * @see blservice.saleblservice.SaleBLService
 * @author cylong
 * @version 2014年11月28日 下午7:46:58
 */
public class SaleController implements SaleBLService {

	private Sale sale;

	public SaleController() {
		sale = new Sale();
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#addCommodities(vo.CommodityItemVO)
	 */
	public void addCommodities(CommodityItemVO itemVO) {
		sale.addCommodities(itemVO);
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#show()
	 */
	public ArrayList<ValueObject> show(BillType type) {
		return sale.show();
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#getID(dataenum.BillType)
	 */
	public String getID(BillType type) {
		return sale.getID(type);
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#submit(blservice.saleblservice.SaleInputInfo)
	 */
	public ResultMessage submit(SaleInputInfo inputInfo) {
		return sale.submit(inputInfo);
	}

	/**
	 * @see blservice.saleblservice.SaleBLService#save(blservice.saleblservice.SaleInputInfo)
	 */
	public ResultMessage save(SaleInputInfo inputInfo) {
		return sale.save(inputInfo);
	}

}
