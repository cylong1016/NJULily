package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataenum.Storage;
import vo.SaleDetailVO;
import businesslogic.common.DateOperate;
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
	public SaleDetailList(String beginDate, String endDate) {
		Date begin = DateOperate.changeBeginDate(beginDate);
		Date end = DateOperate.changeEndDate(endDate);
		this.info = new SaleInfo(begin, end);
	}
	
	public void setInfo(String commodityName, String clientName, String salesman, Storage storage) {
		this.clientName = clientName;
		this.salesman = salesman;
		this.storage = storage;
		this.commodityName = commodityName;
		VOs = new ArrayList<SaleDetailVO>();	
	}
	/**
	 * 
	 * @author Zing
	 * @version Dec 4, 2014 8:20:07 PM
	 * @throws RemoteException 
	 */
	public ArrayList<SaleDetailVO> getSaleDetail() throws RemoteException {
		ArrayList<String> salesIDs = info.getSaleIDs(clientName, salesman, storage);
		// 如果没有单子的话，就返回null
		if (salesIDs.isEmpty()) {
			return null;
		}
		for (String ID : salesIDs) {
			// 如果筛选条件为空，就查看这个单据所有的ID
			if (commodityName == null) {
				for (String commodityID : info.getAllCommodityID(ID)) {
					SaleDetailVO vo = new SaleDetailVO(ID.split("-")[1], info.getCommodityName(commodityID),
							info.getCommodityType(commodityID), info.getCommodityNumber(commodityID), info.getCommodityPrice(commodityID));
					VOs.add(vo);
				}
			}
			else {
				String commodityID = info.getCommodityID(ID, commodityName);
				// 如果没有找到这个商品，就继续循环
				if (commodityID == null) {
					continue;
				}
				SaleDetailVO vo = new SaleDetailVO(ID.split("-")[1], info.getCommodityName(commodityID),
						info.getCommodityType(commodityID), info.getCommodityNumber(commodityID), info.getCommodityPrice(commodityID));
				VOs.add(vo);
			}
		}
		return VOs;
	}
}
