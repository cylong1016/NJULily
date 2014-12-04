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
 * 在此类中包含ArrayList类，用来保存数据【客户，商品等数据】然后添加了保存数据和读取数据的方法【序列化】
 * @author cylong
 * @version Oct 13, 2014 12:03:20 AM
 */
public class DefineList<E> implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 保存的路径和文件名【统一用相对路径保存在data文件夹下】 */
	private String filePath = null;
	/** 用来保存数据的ArrayList */
	private ArrayList<E> inList = new ArrayList<E>();

	public ArrayList<E> getInList() {
		return this.inList;
	}

	public boolean add(E e) {
		boolean b = inList.add(e);
		save();
		return b;
	}

	public void add(int index, E element) {
		inList.add(index, element);
		save();
	}

	public E get(int index) {
		return inList.get(index);
	}

	public void clear() {
		inList.clear();
		save();
	}

	public E remove(int index) {
		E e = inList.remove(index);
		save();
		return e;
	}

	public boolean remove(Object o) {
		boolean b = inList.remove(o);
		save();
		return b;
	}

	public E set(int index, E element) {
		E e = inList.set(index, element);
		save();
		return e;
	}

	public int size() {
		return inList.size();
	}

	public boolean isEmpty() {
		return inList.isEmpty();
	}

	/**
	 * @param filePath 保存的文件的路径，统一用相对路径保存在data文件夹下
	 * @author cylong
	 * @version Oct 13, 2014 12:08:24 AM
	 */
	public DefineList(String filePath) {
		this.filePath = filePath;
		// 每次运行程序的时候自动读取数据
		this.load();
	}

	/**
	 * 从本地磁盘读取数据【集合】，然后保存到ArrayList中
	 * @author cylong
	 * @version Oct 13, 2014 12:21:22 AM
	 */
	@SuppressWarnings("unchecked")
	private void load() {
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
			inList = (ArrayList<E>)ois.readObject();
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
	 * 将数据【集合】存入本地磁盘，使用序列化的方式
	 * @author cylong
	 * @version Oct 13, 2014 12:23:13 AM
	 */
	public void save() {
		/* 将商品集合存入文件中 */
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filePath));
			oos.writeObject(inList);
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
