package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.Storage;
import vo.SaleDetailVO;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.salebl.SaleInfo;

/**
 * 查看销售明细表（统计一段时间内商品的销售情况（应该就是查询销售出货单据记录）
 * 筛选条件有：时间区间，商品名，客户，业务员，仓库。
 * 显示符合上述条件的商品销售记录，以列表形式显示，列表中包含如下信息：
 * 时间（精确到天），商品名，型号，数量，单价，总额。
 * 需要支持导出数据。）
 * @author Zing
 * @version Dec 4, 2014 8:14:12 PM
 */
public class SaleDetailList {

	/** 客户名 */
	public String clientName;
	/** 业务员 */
	public String salesman;
	/** 仓库 */
	public Storage storage;
	/** 商品名 */
	public String commodityName;
	/** 销售单ID */
	public String saleID;
	
	public SaleInfo_Record info;
	
	SaleDetailListItem item;
	
	ArrayList<SaleDetailVO> VOs;
		
	/**
	 * 传入筛选单子的条件
	 * @param commodityName
	 * @param clientName
	 * @param salesman
	 * @param storage
	 */
	public SaleDetailList(String commodityName, String clientName, String salesman, Storage storage) {
		this.clientName = clientName;
		this.salesman = salesman;
		this.storage = storage;
		this.commodityName = commodityName;
		VOs = new ArrayList<SaleDetailVO>();
	}
	
	/**
	 * 
	 * @param IDs
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 8:20:07 PM
	 * @throws RemoteException 
	 */
	public ArrayList<SaleDetailVO> getSaleDetail(ArrayList<String> IDs) throws RemoteException {
		info = new SaleInfo();
		if (IDs.isEmpty()) {
			addVOs(null);
		}
		else {
			for (String id : IDs) {
				addVOs(id);
			}
		}
		
		return VOs;
	}
	
	private void addVOs(String id) throws RemoteException {
		ArrayList<String> saleIDs = info.getID(id, clientName, salesman, storage);
		for (String saleID : saleIDs) {
			item = new SaleDetailListItem(saleID, commodityName);
			SaleDetailVO vo = new SaleDetailVO(saleID, item.name, item.type, item.number, item.price);
			VOs.add(vo);
			}	
	}
	
}
