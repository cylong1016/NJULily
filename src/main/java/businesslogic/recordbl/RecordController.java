package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BusinessStateVO;
import vo.SaleDetailVO;
import vo.ValueObject;
import dataenum.BillType;
import blservice.recordblservice.RecordBLService;
import blservice.recordblservice.RecordInputInfo;

/**
 * @see blservice.recordblservice.RecordBLService
 * @author cylong
 * @version 2014年12月14日 下午5:02:44
 */
public class RecordController implements RecordBLService {

	private Record record;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午5:04:07
	 */
	public RecordController() {
		record = new Record();
	}

	/**
	 * @see blservice.recordblservice.RecordBLService#saleDetail(blservice.recordblservice.RecordInputInfo)
	 */
	@Override
	public ArrayList<SaleDetailVO> saleDetail(RecordInputInfo info) {
		try {
			return record.saleDetail(info);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.recordblservice.RecordBLService#bussinessPro(blservice.recordblservice.RecordInputInfo)
	 */
	@Override
	public ArrayList<ValueObject> bussinessPro(RecordInputInfo info) {
		try {
			return record.bussinessPro(info);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.recordblservice.RecordBLService#red(vo.ValueObject, dataenum.BillType)
	 */
	@Override
	public ValueObject red(ValueObject valueRecord, BillType type) {
		try {
			return record.red(valueRecord, type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.recordblservice.RecordBLService#copyRed(vo.ValueObject, dataenum.BillType)
	 */
	@Override
	public ValueObject copyRed(ValueObject valueRecord, BillType type) {
		try {
			return record.copyRed(valueRecord, type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.recordblservice.RecordBLService#businessState(java.lang.String, java.lang.String)
	 */
	@Override
	public BusinessStateVO businessState(String beginDate, String endDate) {
		try {
			return record.businessState(beginDate, endDate);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
