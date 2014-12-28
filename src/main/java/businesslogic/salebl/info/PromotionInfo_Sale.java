package businesslogic.salebl.info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.promotion.PromotionBargainVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
import vo.promotion.PromotionTotalVO;

public interface PromotionInfo_Sale {

	/**
	 * 查看是否有合适的商品的促销
	 * @deprecated 这个促销策略已经被我们狠心遗弃
	 * @param iD
	 * @param commodityIDs
	 * @author Zing
	 * @version Dec 9, 2014 6:01:53 PM
	 * @param commodityNumber 
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity(String iD, ArrayList<String> commodityIDs, ArrayList<Integer> commodityNumber) throws RemoteException;

	/**
	 * 查看是否有合适的客户等级的促销
	 * @param iD
	 * @param clientID
	 * @author Zing
	 * @version Dec 9, 2014 6:02:12 PM
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionClientVO> findFitPromotionClient(String iD, String clientID) throws RemoteException;

	/**
	 * 查看是否有合适的总价的促销
	 * @param iD
	 * @param beforePrice
	 * @author Zing
	 * @version Dec 9, 2014 6:02:35 PM
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionTotalVO> findFitPromotionTotal(String iD, double beforePrice) throws RemoteException;

	public ArrayList<PromotionBargainVO> showBargains() throws RemoteException;
	
	public PromotionBargainVO findBargains(String iD) throws RemoteException;
	
}
