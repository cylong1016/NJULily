package businesslogic.recordbl;

import java.util.ArrayList;

import blservice.recordblservice.RecordBLService;
import blservice.recordblservice.RecordInputInfo;
import message.ResultMessage;
import vo.SaleDetailVO;
import vo.ValueObject;

/**
 * 查看销售明细表（统计一段时间内商品的销售情况（应该就是查询销售出货单据记录），
 * 筛选条件有：时间区间，商品名，客户，业务员，仓库。
 * 显示符合上述条件的商品销售记录，以列表形式显示，
 * 列表中包含如下信息：时间（精确到天），商品名，型号，数量，单价，总额。需要支持导出数据。）
 * @author Zing
 * @version Nov 16, 20149:29:17 AM
 */
public class RecordController implements RecordBLService{
	
	private Record record;
	
	public RecordController(){
		record = new Record();
	}

	public ArrayList<SaleDetailVO> saleDetail(RecordInputInfo info) {
		return record.saleDetail(info);
	}

	public ArrayList<ValueObject> bussinessPro(RecordInputInfo info) {
		return record.bussinessPro(info);
	}

	public ResultMessage red(ValueObject valueRecord) {
		return record.red(valueRecord);
	}

	public ResultMessage copyRed(ValueObject valueRecord) {
		return record.copyRed(valueRecord);
	}

	public ResultMessage businessState(RecordInputInfo info) {
		return record.businessState(info);
	}


	
}
