package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * <p>保存和读取数据</p>
 * 在此类中包含ArrayList类，用来保存数据【客户，商品等数据】然后添加了保存数据和读取数据的方法【序列化】，暂时是本地保存
 * @author cylong
 * @version Oct 13, 2014 12:03:20 AM
 */
public class DefineList<T> implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 保存的路径和文件名【统一用相对路径保存在data文件夹下】 */
	private String filePath = null;
	/** 用来保存数据的ArrayList */
	private ArrayList<T> innerList = new ArrayList<T>();

	public ArrayList<T> getInnerList() {
		return this.innerList;
	}

	/**
	 * @param filePath 保存的文件的路径，统一用相对路径保存在data文件夹下
	 * @author cylong
	 * @version Oct 13, 2014 12:08:24 AM
	 */
	public DefineList(String filePath) {
		this.filePath = filePath;
		// 每次运行程序的时候自动读取数据
		this.loadList();
	}

	/**
	 * 从磁盘读取数据【集合】，然后保存到ArrayList中
	 * @author cylong
	 * @version Oct 13, 2014 12:21:22 AM
	 */
	@SuppressWarnings("unchecked")
	private void loadList() {
		/* 没有该文件夹就创建 */
		File dataFolder = new File("data");
		if (!dataFolder.isDirectory()) {
			dataFolder.mkdirs();
		}
		/* 如果没有该文件就创建 */
		File dataFile = new File(filePath);
		if (!dataFile.isFile()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 判断文件是否为空
		/* 这块用来修复文件里什么内容都没有的时候读出数据错误的bug */
		if (dataFile.length() == 0) {
			return;
		}
		/* 从文件中读取数据 */
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filePath));
			innerList = (ArrayList<T>)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将数据【集合】存入文件，使用序列化的方式
	 * @author cylong
	 * @version Oct 13, 2014 12:23:13 AM
	 */
	public void saveList() {
		/* 将商品集合存入文件中 */
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filePath));
			oos.writeObject(innerList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
