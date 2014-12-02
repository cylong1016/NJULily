package server.data.purchasedata;

import po.PurchasePO;
import server.data.TableInfo;
import dataenum.Storage;

/**
 * dataservice.purchasedataservice.PurchaseInfoService
 * @author cylong
 * @version 2014年12月2日 上午3:28:29
 */
public class PurchaseInfo extends TableInfo<PurchasePO> {

	private PurchaseData purchaseData;

	/**
	 * @see server.data.TableInfo#initPOs()
	 */
	@Override
	protected void initPOs() {
		purchaseData = new PurchaseData();
		pos = purchaseData.show();
	}

	/**
	 * @see server.data.TableInfo#getClient(java.lang.String)
	 */
	@Override
	public String getClient(String billID) {
		return purchaseData.find(billID).getClient();
	}

	/**
	 * @see server.data.TableInfo#getStorage(java.lang.String)
	 */
	@Override
	public Storage getStorage(String billID) {
		return purchaseData.find(billID).getStorage();
	}

}
