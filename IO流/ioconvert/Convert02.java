/**
 * 
 */
package com.xyd.ioconvert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

import com.xyd.IOUtils;

/**
 * @author scott
 * @date 2017年12月22日上午10:46:34
 * @version 
 * @description  OutputStreamWriter—> 将字节流转换为字符流
 */
public class Convert02 {

	public static void main(String[] args) {
		
		write("d:/b.txt");
		
	}

	private static void write(String str) {
		//字节输出流
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			
			fos= new FileOutputStream(new File(str));
			osw = new OutputStreamWriter(fos);
			
			osw.write("今晚吃饺子吗\r\n");
			osw.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtils.close(fos,osw);
		}
	}
}
