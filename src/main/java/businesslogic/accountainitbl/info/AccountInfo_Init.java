package businesslogic.accountainitbl.info;

import java.util.ArrayList;

import po.AccountPO;
import vo.AccountVO;

public interface AccountInfo_Init {
	
	public ArrayList<AccountVO> getAccountVOs(ArrayList<AccountPO> POs);
	
	public ArrayList<AccountPO> getAccountPOs();
}
