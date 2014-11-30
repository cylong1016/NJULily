package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 所有po类的父类，包括创建时间，编号,即使大作业说明中有些单子没有编号和时间，但是我还是建议加上去
 * @author cylong
 * @version Oct 25, 2014 11:02:36 PM
 */
public class PersistentObject implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 单据编号，格式根据不同单据而不同 */
	protected String ID;
	/** 时间 ，由系统自动生成 */
	protected String date;

	/**
	 * 用来自动生成日期和单据编号
	 * @author cylong
	 * @version Oct 25, 2014 11:31:44 PM
	 */
	public PersistentObject(String ID) {
		this.ID = ID;
		/* 自动生成日期 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = sdf.format(new Date());
	}

	/**
	 * 供外部创建或者修改单子的编号
	 * @param id
	 * @author cylong
	 * @version Oct 25, 2014 11:43:37 PM
	 */
	public void setID(String ID) {
		this.ID = ID;
	}

	public String getID() {
		return this.ID;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersistentObject other = (PersistentObject)obj;
		if (this.ID == null) {
			if (other.ID != null)
				return false;
		} else if (!this.ID.equals(other.ID))
			return false;
		return true;
	}

}
