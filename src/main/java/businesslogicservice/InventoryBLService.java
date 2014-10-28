package businesslogicservice;

import java.util.ArrayList;

import vo.ClientVO;
import vo.CommodityVO;
import dataenum.Date;
import message.ResultMessage;

/**
 * 负责实现仓库管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:09:11 PM
 */
/**
 * 添加内容
 * @author soujing
 * @version 2014年10月27日下午4:48:12
 */
public interface InventoryBLService {
	
	
	public ResultMessage view (Date beginDate, Date endDate);
	
	public ResultMessage checkRecord();
	
	public ResultMessage giftRecord(ArrayList<CommodityVO> commodities, int commoNum, ClientVO client);
	
	public ResultMessage overflowRecord(Commodity commodity, int num);
	
	public ResultMessage lossRecor(Commodity commodity, int num);
	
	public ResultMessage alarmRecord(Commodity commodity, int num);




}
