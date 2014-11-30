package server.common;

import java.util.ArrayList;

import po.PersistentObject;

/**
 * 一些通用的方法
 * @author cylong
 * @version Nov 11, 2014 10:37:05 PM
 */
public class Common {

	/**
	 * 删除集合中两个相同的元素
	 * @param list
	 * @return 集合中是否有重复的元素
	 * @author cylong
	 * @version Nov 11, 2014  10:49:06 PM
	 */
	public static boolean deleteRep(ArrayList<? extends PersistentObject> list) {
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				PersistentObject po = list.get(j);
				if(list.get(i).equals(po)) {
					list.remove(po);
					j--;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 将int转化成String
	 * @param val int值
	 * @param bit String的长度，不足的以0补齐
	 * @return 转化后的String
	 * @author cylong
	 * @version 2014年11月30日  下午11:14:02
	 */
	public static String intToString(int val, int bit) {
		String res = Integer.toString(val);
		for(int i = res.length(); i < bit; i++) {
			res = 0 + res;
		}
		return res;
	}
}
