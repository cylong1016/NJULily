package businesslogic.commoditybl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import vo.commodity.CommodityAddVO;
import vo.commodity.CommodityUpdateVO;
import vo.commodity.CommodityVO;
import dataenum.FindTypeCommo;
import blservice.commodityblservice.CommodityBLService;

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
		try {
			commodity = new Commodity();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
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
			return commodity.show(ID);
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
			return commodity.addCommo(addVO);
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
			return commodity.deletCommo(ID);
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
			return commodity.updCommo(ID, updateVO);
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
			return commodity.setAlarm(IDs, alarmNumber);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
