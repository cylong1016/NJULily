package businesslogic.recordbl;

import blservice.recordblservice.RecordBLService;
import message.ResultMessage;
import vo.ValueObject;
import dataenum.BillType;
import dataenum.Storage;

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

	public ResultMessage saleDetail(String begin, String end, String commodity,
			String client, String salesman, Storage Storage) {
		return record.saleDetail(begin, end, commodity, client, salesman, Storage);
	}

	public ResultMessage bussinessPro(String begin, String end,
			BillType billType, String client, String salesman, Storage storage) {
		return record.bussinessPro(begin, end, billType, client, salesman, storage);
	}

	public ResultMessage red(ValueObject valueRecord) {
		return record.red(valueRecord);
	}

	public ResultMessage copyRed(ValueObject valueRecord) {
		return record.copyRed(valueRecord);
	}

	public ResultMessage businessState(String begin, String end) {
		return record.businessState(begin, end);
	}


	
}
