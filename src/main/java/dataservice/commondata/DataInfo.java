package dataservice.commondata;

import java.util.ArrayList;

import dataenum.Storage;

/**
 * 
 * @author cylong
 * @version 2014年12月1日  下午4:03:20
 */
public interface DataInfo {
	
	public ArrayList<String> getAllID();
	
	public String getClient(String billID);
	
	public String getSalesman(String billID);
	
	public Storage getStorage(String billID);
}
