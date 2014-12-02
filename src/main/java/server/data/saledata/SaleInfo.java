package server.data.saledata;

import po.SalesPO;
import server.data.TableInfo;
import dataenum.Storage;

/**
 * @see dataservice.saledataservice.SaleInfoService
 * @author cylong
 * @version 2014年12月2日 上午3:29:07
 */
public class SaleInfo extends TableInfo<SalesPO> {

	private SaleData saleData;

	/**
	 * @see server.data.TableInfo#initPOs()
	 */
	@Override
	protected void initPOs() {
		saleData = new SaleData();
		pos = saleData.show();
	}

	/**
	 * 由子类实现
	 * @see dataservice.TableInfoService#getClient(java.lang.String)
	 */
	@Override
	public String getClient(String billID) {
		return saleData.find(billID).getClient();
	}

	/**
	 * 由子类实现
	 * @see dataservice.TableInfoService#getSalesman(java.lang.String)
	 */
	@Override
	public String getSalesman(String billID) {
		return saleData.find(billID).getSalesman();
	}

	/**
	 * 由子类实现
	 * @see dataservice.TableInfoService#getStorage(java.lang.String)
	 */
	@Override
	public Storage getStorage(String billID) {
		return saleData.find(billID).getStorage();
	}

}
