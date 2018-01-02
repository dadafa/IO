/**
 * 
 */
package com.xyd.bytearray;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.xyd.IOUtils;

/**
 * @author scott
 * @date 2017年12月22日下午2:33:30
 * @version
 * @description 数据流的读写 DataInputStream DataOutputStream DataInputStream(in) 构造器
 *              (输入流) DataOutputStream(out) 构造器 (输出流)
 * 
 *              写的方法方法: 
 *               writeUTF() 写字符串 
 *               writeInt() 写int 
 *               writeFloat() 写Float
 *               writeLong() 写Long
 *               
 *               读取的操作 顺要一致 
 */
public class DataInputstreamDemo01 {

	public static void main(String[] args) {

		File file = new File("src/d.txt");
		write(file);

		read(file);
	}

	/**
	 * 用dateinputStream  读取数据
	 */
	private static void read(File file) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(file));
			
			String msg = dis.readUTF();
			int readInt = dis.readInt();
			
			float readFloat = dis.readFloat();
			long readLong = dis.readLong();
			System.out.println(readInt);
			System.out.println(msg);
			System.out.println(readFloat);
			System.out.println(readLong);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.close(dis);
			System.out.println("写完了...");
		}
		
	}

	/**
	 * 用 dataoutputStream 写输入数据
	 */
	private static void write(File src) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(src));

			dos.writeUTF("科比球衣退役了");

			dos.writeInt(34);
			dos.writeFloat(2.3f);
			dos.writeLong(45L);

			dos.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.close(dos);
			System.out.println("写完了...");
		}
	}

}
