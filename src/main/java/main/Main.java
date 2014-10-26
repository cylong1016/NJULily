package main;

import businesslogic.userbl.UserBLService_Driver;
import businesslogic.userbl.UserBLService_Stub;
import businesslogicservice.UserBLService;

/**
 * @author cylong
 * @version Oct 26, 2014 9:04:33 PM
 */
public class Main {

	public static void main(String[] args) {
		UserBLService userBL = new UserBLService_Stub();
		UserBLService_Driver driver = new UserBLService_Driver();
		driver.drive(userBL);
	}
}
