package businesslogic.salebl;

import java.rmi.Naming;
import java.util.ArrayList;

import org.junit.runner.notification.Failure;

import businesslogic.approvalbl.WaitApproval;
import businesslogic.clientbl.Client;
import po.SalesPO;
import vo.SalesVO;
import message.ResultMessage;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.ApprovalDataService;
import dataservice.DataFactoryService;
import dataservice.SaleDataService;
/**
 * Sale和SaleDataService是依赖关系
 * @author Zing
 * @version Nov 15, 201410:07:38 AM
 */
public class Sale extends WaitApproval{
	
	private SaleList saleList;
	
	private SalesPO po;
	
	private BillType type;
	
	private String ID;
		
	public Sale() {
		this.saleList = new SaleList();
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
	 * 添加商品
	 * @param ID
	 * @param num
	 * @param price
	 * @param remark
	 */
	public void addCommodities(String ID, int num, double price, String remark) {
		SaleListItem item = new SaleListItem(ID, num, price, remark);
		saleList.add(item);
	}

	/**
	 * 得到折让后的价格
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @return
	 */
	public double getAfterPrice(double beforePrice, double allowance, double voucher) {
		return beforePrice - allowance - voucher;
	}
	
	public SaleDataService getSaleData(){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			SaleDataService saleData = (SaleDataService)factory.getSaleData();
			return saleData;		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	

	/**
	 * 建立销售单
	 * @param client
	 * @param salesman
	 * @param user
	 * @param storage
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @return
	 */
	public SalesPO add(String clientID,  Storage storage, double allowance, double voucher, String remark, BillType type) {
		double beforePrice = saleList.getBeforePrice();
		double afterPrice = getAfterPrice(beforePrice, allowance, voucher);
		ClientInfo info = new Client();		
		po = new SalesPO(ID, info.getNamee(clientID), info.getSalesman(clientID), user, storage, saleList.getCommodities(), beforePrice, allowance, voucher, remark, afterPrice, type);
		
		return po;
	}


	public ArrayList<SalesVO> show(){
		SaleDataService saleData = getSaleData();
		// TODO
		return null;
	}

	public ResultMessage submit(String clientID, Storage storage, double allowance, double voucher, String remark) {
		SalesPO po = null;
		switch (type) {
		case SALE:
			po = add(clientID, storage, allowance, voucher, remark, BillType.SALE);
			break;
		case SALEBACK:
			po = add(clientID, storage, allowance, voucher, remark, BillType.SALEBACK);
			break;
		default:
			break;
		}
		getApprovalData().insert(po);		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(String clientID, Storage storage, double allowance, double voucher, String remark) {
		SalesPO po = null;
		switch (type) {
		case SALE:
			po = add(clientID, storage, allowance, voucher, remark, BillType.SALE);
			break;
		case SALEBACK:
			po = add(clientID, storage, allowance, voucher, remark, BillType.SALEBACK);
			break;
		default:
			break;
		}
		// TODO 保存在本地
		return ResultMessage.SUCCESS;
	}

}
