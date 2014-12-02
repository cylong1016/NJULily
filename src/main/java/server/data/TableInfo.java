package server.data;

import java.util.ArrayList;

import po.PersistentObject;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;

/**
 * @see dataservice.TableInfoService
 * @author cylong
 * @version 2014年12月2日 下午7:19:10
 */
public abstract class TableInfo<PO extends PersistentObject> implements TableInfoService<PO> {

	protected ArrayList<PO> pos;

	public TableInfo() {
		initPOs();
	}

	/**
	 * 初始化相应账单的ArrayList
	 * @author cylong
	 * @version 2014年12月2日 下午7:28:38
	 */
	protected abstract void initPOs();

	/**
	 * @see dataservice.TableInfoService#getAllID(dataenum.BillType)
	 */
	@Override
	public ArrayList<String> getAllID(BillType type) {
		ArrayList<String> IDs = new ArrayList<String>();
		for(PO po : pos) {
			IDs.add(po.getID());
		}
		return IDs;
	}

	/**
	 * 由子类实现
	 * @see dataservice.TableInfoService#getClient(java.lang.String)
	 */
	@Override
	public String getClient(String billID) {
		return null;
	}

	/**
	 * 由子类实现
	 * @see dataservice.TableInfoService#getSalesman(java.lang.String)
	 */
	@Override
	public String getSalesman(String billID) {
		return null;
	}

	/**
	 * 由子类实现
	 * @see dataservice.TableInfoService#getStorage(java.lang.String)
	 */
	@Override
	public Storage getStorage(String billID) {
		return null;
	}

	/**
	 * @see dataservice.TableInfoService#show()
	 */
	@Override
	public ArrayList<PO> show() {
		return pos;
	}

}
