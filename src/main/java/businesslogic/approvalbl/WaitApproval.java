package businesslogic.approvalbl;

import java.rmi.Naming;

import dataservice.ApprovalDataService;
import dataservice.DataFactoryService;

public class WaitApproval {
	
	public ApprovalDataService getApprovalData(){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			ApprovalDataService approvalData = (ApprovalDataService)factory.getApprovalData();
			return approvalData;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}
