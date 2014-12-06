package businesslogic.salebl.info;

/**
 * 由Client实现，获得Client信息
 * @author Zing
 */
public interface ClientInfo_Sale {

	/**
	 * 得到客户对应的默认业务员
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 3, 2014 2:11:55 PM
	 */
	public String getSalesman(String ID);

	/**
	 * 得到客户的名字
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 3, 2014 2:12:10 PM
	 */
	public String getName(String ID);

	/**
	 * 更改客户的应收
	 * @param clientID
	 * @param afterPrice
	 * @author Zing
	 * @version Dec 3, 2014 2:11:32 PM
	 */
	public void changeReceivable(String clientID, double afterPrice);
}
