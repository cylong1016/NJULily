package vo;


/**
 * 账户值对象
 * @author cylong
 * @version Oct 26, 2014  2:24:39 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月31日下午9:30:03
 */
public class AccountVO {
	/** 账户名*/
	public String name;
	/** 账户余额 */
	public double money;
	
	public AccountVO(String name, double money){
		this.name = name;
		this.money = money;
	}
}
