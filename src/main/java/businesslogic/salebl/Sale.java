package businesslogic.salebl;

import java.rmi.Naming;
import java.util.ArrayList;
import message.ResultMessage;
import po.SalesPO;
import vo.SalesVO;
import businesslogic.approvalbl.WaitApproval;
import businesslogic.clientbl.Client;
import businesslogic.inventorybl.info.SaleInfo;
import config.RMI;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.DataFactoryService;
import dataservice.SaleDataService;

/**
 * Sale和SaleDataService是依赖关系
 * @author Zing
 * @version Nov 15, 201410:07:38 AM
 */
public class Sale extends WaitApproval implements SaleInfo {

	private SaleList list;

	private SalesPO po;

	private BillType type;

	private String ID;

	public Sale() {
		this.list = new SaleList();
	}
	
	public SaleDataService getSaleData() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			SaleDataService saleData = (SaleDataService)factory.getSaleData();
			return saleData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 每次要创建单据前，都要根据单据的类型得到ID
	 * @param type
	 * @return
	 */
	public String getID(BillType type) {
		this.type = type;
		SaleDataService saleData = getSaleData();
		this.ID = saleData.getID(type);
		return ID;
	}

	/**
	 * 添加一条商品信息
	 */
	public void addCommodities(String ID, int num, double price, String remark) {
		SaleListItem item = new SaleListItem(ID, num, price, remark);
		list.add(item);
	}

	/**
	 * 建立销售单
	 * @return
	 */
	public SalesPO buildSales() {
		double beforePrice = list.getBeforePrice();
		double afterPrice = list.getAfterPrice();
		ClientInfo info = new Client();
		// TODO user从文件中读取当前登陆的用户
		po = new SalesPO(ID, info.getName(list.getClientID()), info.getSalesman(list.getClientID()),  "user", list.getStorage(), list.getCommodities(), beforePrice, list.getAllowance(), list.getVoucher(), list.getRemark(), afterPrice, type);
		return po;
	}

	public ArrayList<SalesVO> show() {

		SaleDataService saleData = getSaleData();
		// saleData.getAllSaleBills();
		return null;
	}

	public ResultMessage submit(String clientID, Storage storage, double allowance, double voucher, String remark) {
		list.setClientID(clientID);
		list.setStorage(storage);
		list.setAllowance(allowance);
		list.setVoucher(voucher);
		list.setRemark(remark);
		
		SalesPO po = buildSales();
		getApprovalData().insert(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(String clientID, Storage storage, double allowance, double voucher, String remark) {
		list.setClientID(clientID);
		list.setStorage(storage);
		list.setAllowance(allowance);
		list.setVoucher(voucher);
		list.setRemark(remark);
		
	//	SalesPO po = buildSales();
		// TODO 保存在本地
		return ResultMessage.SUCCESS;
	}

	public ArrayList<Double> getMoney(String begin, String end) {
		// TODO 需要根据日期查询ID的方法，返回我一个arrylistID。或者我自己查，那就提供一个返回所有PO的方法
//		SaleDataService saleData = getSaleData();
		return null;
	}

	public ArrayList<Integer> getNumber(String begin, String end) {
		return null;
	}

}
