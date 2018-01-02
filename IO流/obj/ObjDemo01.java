/**
 * 
 */
package com.xyd.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.xyd.IOUtils;

/**
 * @author scott
 * @date 2017年12月22日下午2:47:39
 * @version 
 * @description  用对象流读写把对象 写到文件中
 * 
 *    ObjectOutputStream(输出流) 构造器  要给 输出流
 *    
 *   ObjectInputStream(输入流)
 *    操作的方法: 
 *       writeObj(obj)
 *       
 *       Object obj = readObj();
 *  
 *  序列化:  把对象 转成二进制  写到 文件中 
 *  
 *   java.io.NotSerializableException: com.xyd.obj.Student 报错信息(写入的对象没有实现 序列化) 类实现序列化接口（Serializable）
 */
public class ObjDemo01 {



	public static void main(String[] args) {

		File file = new File("src/obj.txt");
		
		write(file);
		
		read(file);
	}

	/***
	 * 用 DataInputStream 读取文件中的 序列化对象
	 */
	private static void read(File file) {

		//选择流
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			
			Object obj = ois.readObject();
			
			if ( obj instanceof Student) {
				Student stu = (Student) obj;
				System.out.println(stu);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtils.close(ois);
		}
	}e

	/*
	 * 用 obj流把对象 写到文件中 
	 */
	private static void write(File file) {
		
		//选择流
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			//操作
			Student stu = new Student(23, "高晓松", 50);
			oos.writeObject(stu);
			
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			IOUtils.close(oos);
			System.out.println("写入完毕...");
		}
		
	}
}
