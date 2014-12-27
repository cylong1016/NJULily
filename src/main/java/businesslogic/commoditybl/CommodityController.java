package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogMsgController;
import vo.commodity.CommodityAddVO;
import vo.commodity.CommodityUpdateVO;
import vo.commodity.CommodityVO;
import blservice.commodityblservice.CommodityBLService;
import dataenum.FindTypeCommo;
import dataenum.ResultMessage;

/**
 * @see blservice.commodityblservice.CommodityBLService
 * @author cylong
 * @version 2014年12月14日 下午1:06:22
 */
public class CommodityController implements CommodityBLService {

	private Commodity commodity;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午1:10:23
	 */
	public CommodityController() {
		commodity = new Commodity();
	}

	/**
	 * @see blservice.commodityblservice.CommodityBLService#show()
	 */
	@Override
	public ArrayList<CommodityVO> show() {
		try {
			return commodity.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.commodityblservice.CommodityBLService#show(java.lang.String)
	 */
	@Override
	public CommodityVO show(String ID) {
		try {
			CommodityVO vo = commodity.show(ID);
			LogMsgController.addLog("查看商品信息 [商品ID=" + ID + "]");
			return vo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.commodityblservice.CommodityBLService#getID(java.lang.String)
	 */
	@Override
	public String getID(String sortID) {
		try {
			return commodity.getID(sortID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.commodityblservice.CommodityBLService#addCommo(vo.commodity.CommodityAddVO)
	 */
	@Override
	public ResultMessage addCommo(CommodityAddVO addVO) {
		try {
			ResultMessage res = commodity.addCommo(addVO);
			if (res.equals(ResultMessage.SUCCESS)) {
				LogMsgController.addLog("添加商品 " + addVO.toString());
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.commodityblservice.CommodityBLService#deletCommo(java.lang.String)
	 */
	@Override
	public ResultMessage deletCommo(String ID) {
		try {
			ResultMessage res = commodity.deletCommo(ID);
			if (res.equals(ResultMessage.SUCCESS)) {
				LogMsgController.addLog("删除商品 [商品ID=" + ID + "]");
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.commodityblservice.CommodityBLService#updCommo(java.lang.String,
	 *      vo.commodity.CommodityUpdateVO)
	 */
	@Override
	public ResultMessage updCommo(String ID, CommodityUpdateVO updateVO) {
		try {
			ResultMessage res = commodity.updCommo(ID, updateVO);
			if (res.equals(ResultMessage.SUCCESS)) {
				LogMsgController.addLog("更改商品 [商品ID＝" + ID + "]" + updateVO.toString());
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.commodityblservice.CommodityBLService#findCommo(java.lang.String,
	 *      dataenum.FindTypeCommo)
	 */
	@Override
	public ArrayList<CommodityVO> findCommo(String info, FindTypeCommo type) {
		try {
			LogMsgController.addLog("模糊查找商品 [关键字＝" + info + "]");
			return commodity.findCommo(info, type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.commodityblservice.CommodityBLService#setAlarm(java.util.ArrayList, int)
	 */
	@Override
	public ResultMessage setAlarm(ArrayList<String> IDs, int alarmNumber) {
		try {
			LogMsgController.addLog("设置商品的警戒数量");
			return commodity.setAlarm(IDs, alarmNumber);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
