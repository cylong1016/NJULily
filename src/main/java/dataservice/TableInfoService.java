package dataservice;

import java.util.ArrayList;

import po.PersistentObject;
import dataenum.BillType;
import dataenum.Storage;

/**
 * 查看销售明细表，经营情况表时候返回信息
 * @author cylong
 * @version 2014年12月1日  下午4:03:20
 */
public interface TableInfoService<PO extends PersistentObject> {
	
	/**
	 * 根据单据类型返回全部的单据ID
	 * @param type
	 * @return ID的ArrayList
	 * @author cylong
	 * @version 2014年12月1日  下午5:26:46
	 */
	public ArrayList<String> getAllID(BillType type);
	
	/**
	 * 根据单据ID查找其中的用户
	 * @param billID
	 * @return 用户名（name）
	 * @author cylong
	 * @version 2014年12月1日  下午5:24:26
	 */
	public String getClient(String billID);
	
	/**
	 * 根据单据ID查找其中的销售人员
	 * @param billID
	 * @return 销售人员的名字（name）
	 * @author cylong
	 * @version 2014年12月1日  下午5:25:39
	 */
	public String getSalesman(String billID);
	
	/**
	 * 根据单据ID查找其中的仓库
	 * @param billID
	 * @return Storage
	 * @author cylong
	 * @version 2014年12月1日  下午5:26:18
	 */
	public Storage getStorage(String billID);
	
	/**
	 * @return 全部的单子
	 * @author cylong
	 * @version 2014年12月2日  上午3:04:02
	 */
	public ArrayList<PO> show();
	
}
