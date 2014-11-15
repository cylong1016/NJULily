package po;

public class waitApprovalPO {
	
	private PersistentObject po;
	
	public waitApprovalPO(PersistentObject po){
		this.setPo(po);
	}

	public PersistentObject getPo() {
		return po;
	}

	public void setPo(PersistentObject po) {
		this.po = po;
	}

}
