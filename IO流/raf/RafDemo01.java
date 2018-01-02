/**
 * 
 */
package com.xyd.raf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author scott
 * @date 2017年12月22日下午4:04:56
 * @version 
 * @description   RandomAccessFile(f,"rw")  构造器   "rw"  read  write
 *                                                 r    只能读 
 *                                                 
 *                RandomAccessFile 方法很多 : 读写都是这个类
 *                                                 
 */
public class RafDemo01 {

	public static void main(String[] args) {
		
		File file = new File("src/raf01.txt");
		
		write(file);
		
		read(file);
		
	}

	private static void read(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			
			//文件的大小
			System.out.println(raf.length());
			
			//可以跳过 一些数据
			raf.skipBytes(12);
			int readInt = raf.readInt();
			
			// 设置从那个敌方开始
			raf.seek(12);
			int readInt2 = raf.readInt();
//			double readDouble = raf.readDouble();
//			int readInt1 = raf.readInt();
//		
//			System.out.println(readInt);
//			System.out.println(readDouble);
			System.out.println(readInt);
			System.out.println(readInt2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *  RandomAccessFile 写如数据
	 */
	private static void write(File file) {

		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.writeInt(3);       //4  
			raf.writeDouble(34d); // 8
			raf.writeInt(5);      // 4
			raf.close();
			
			System.out.println("写入完毕...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
