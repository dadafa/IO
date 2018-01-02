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
 * @date 2017年12月22日下午4:19:17
 * @version 
 * @description 
 */
public class RafDemo02 {

	public static void main(String[] args) {
		
		File file = new File("src/raf02.txt");
		write(file);
		
		read(file);
	}

	private static void read(File file) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = raf.read(buffer)) != -1) {
				String string = new String(buffer, 0, len);
				
				System.out.println(string);
			}
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void write(File file) {
		
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			
			raf.write("今天要提前下班，你们是什么集合".getBytes());
			
			raf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
