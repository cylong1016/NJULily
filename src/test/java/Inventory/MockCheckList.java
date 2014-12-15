package Inventory;

import java.rmi.RemoteException;

import businesslogic.inventorybl.CheckList;

public class MockCheckList extends CheckList {

	String lot;

	public MockCheckList(String lot) throws RemoteException {
		super(lot);
	}

}
