package businesslogic.accountainitbl.info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import vo.commodity.CommodityVO;

public interface CommodityInfo_Init {
	
	public ArrayList<CommodityPO> getCommodityPOs() throws RemoteException;
	
	public ArrayList<CommodityVO> getCommodityVOs(ArrayList<CommodityPO> POs) throws RemoteException;

}
