package businesslogic.accountainitbl.info;

import java.util.ArrayList;

import po.ClientPO;
import vo.ClientVO;

public interface ClientInfo_Init {
	
	public ArrayList<ClientVO> getClientVOs(ArrayList<ClientPO> POs);
	
	public ArrayList<ClientPO> getClientPOs();
}
