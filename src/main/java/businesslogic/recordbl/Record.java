package businesslogic.recordbl;

import message.ResultMessage;
import vo.ValueObject;
import dataenum.BillType;
import dataenum.Storage;

public class Record {
	public ResultMessage saleDetail(String begin, String end, String commodity,
			String client, String salesman, Storage Storage) {
		return null;
	}

	public ResultMessage bussinessPro(String begin, String end,
			BillType billType, String client, String salesman, Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage red(ValueObject valueRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage copyRed(ValueObject valueRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage businessState(String begin, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage earning() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage expense() {
		// TODO Auto-generated method stub
		return null;
	}

}
