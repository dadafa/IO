/**
 * 
 */
package com.xyd.ioconvert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.xml.sax.InputSource;

import com.xyd.IOUtils;

/**
 * @author scott
 * @date 2017年12月22日上午10:34:38
 * @version
 * @description InputStreamReader—> 将字节流转换为字符流。
 * 
 *   中文乱码:
 *    1.编码不统一
 *    2.数据丢失
 */
public class Convert01 {

	public static void main(String[] args) {

		read("d:/b.txt");
	}

	private static void read(String path) {

		// 来个字节流
		FileInputStream fis = null;
		InputStreamReader isr = null;
		try {
			fis = new FileInputStream(path);
			// 用转换流转换   可以给指定的编码格式 
			isr = new InputStreamReader(fis,"utf-8");

			char[] chs = new char[1024];
			int len = 0;
			StringBuilder sb = new StringBuilder();
			while ((len = isr.read(chs)) != -1) {
				String string = new String(chs, 0, len);
				sb.append(string);
			}
			System.out.println(sb.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(fis, isr);
		}
	}
}
