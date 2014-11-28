package businesslogic.approvalbl;

import java.rmi.Naming;

import config.RMI;
import dataservice.ApprovalDataService;
import dataservice.DataFactoryService;

public class WaitApproval {

	public ApprovalDataService getApprovalData() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			ApprovalDataService approvalData = (ApprovalDataService)factory.getApprovalData();
			return approvalData;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
