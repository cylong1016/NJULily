package businesslogic.recordbl;

import java.util.ArrayList;

import dataenum.Storage;
import vo.SaleDetailVO;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.salebl.SaleInfo;

public class SaleDetailList {

	/** 客户名 */
	public String clientName;
	/** 业务员 */
	public String salesman;
	/** 仓库 */
	public Storage storage;
	/** 商品名 */
	public String commodityName;
	
	public String saleID;
	
	public SaleInfo_Record info;
	
	SaleDetailListItem item;
		
	public SaleDetailList(String commodityName, String clientName, String salesman, Storage storage) {
		this.clientName = clientName;
		this.salesman = salesman;
		this.storage = storage;
		this.commodityName = commodityName;
	}
	
	public ArrayList<SaleDetailVO> getSaleDetail(ArrayList<String> IDs) {
		info = new SaleInfo();
		ArrayList<SaleDetailVO> VOs = new ArrayList<SaleDetailVO>();
		for (String id : IDs) {
			ArrayList<String> saleIDs = info.getID(id, clientName, salesman, storage);
			for (String saleID : saleIDs) {
				item = new SaleDetailListItem(saleID, commodityName);
				SaleDetailVO vo = new SaleDetailVO(saleID, item.name, item.type, item.number, item.price);
				VOs.add(vo);
			}
		}
		return VOs;
	}
	
}
