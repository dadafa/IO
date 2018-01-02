/**
 * 
 */
package com.xyd.bytearray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.xyd.IOUtils;

/**
 * @author scott
 * @date 2017年12月22日下午2:25:10
 * @version         FileinputReader  ->ByteArrayOutputStream         ByteArrayInputStream
 * 
 * @description  读取 文字中内容                                      写到 内存 中                                                 读取 内存中的数据 
 * 
 */
public class ByteArrayDemo02 {

	public static void main(String[] args) {
		
		byte[] date = write();
		read(date);
		
	}
	
	private static void read(byte[] date) {

		ByteArrayInputStream bais = new ByteArrayInputStream(date);
		
		byte [] buffer = new byte[1024];
		
		int len =0;
		
		try {
			while ((len = bais.read(buffer)) != -1) {
				String str = new String(buffer, 0, len);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			IOUtils.close(bais);
		}
	}


	/**
	 * 读取文件中的内容   写到   内存中
	 */
	private static byte []  write() {
		
		byte [] date = null;
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			fis = new FileInputStream(new File("src/c.txt"));
			
			bos = new ByteArrayOutputStream();
			
			byte [] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
				bos.flush();
			}
			date = bos.toByteArray();
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtils.close(bos,fis);
		}
		
		return null;
		
	}
}
