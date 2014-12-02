package businesslogic.accountainitbl.info;

import java.util.ArrayList;

import po.CommodityPO;
import vo.CommodityVO;

public interface CommodityInfo_Init {
	
	public ArrayList<CommodityPO> getCommodityPOs();
	
	public ArrayList<CommodityVO> getCommodityVOs(ArrayList<CommodityPO> POs);

}
