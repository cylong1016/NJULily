package businesslogic.promotionbl.info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.InventoryBillVO;

public interface InventoryInfo_Promotion {
	
	public ArrayList<InventoryBillVO> getGifts() throws RemoteException;
}
