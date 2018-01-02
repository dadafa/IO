/**
 * 
 */
package com.xyd.bytearray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.xyd.IOUtils;

/**
 * @author scott
 * @date 2017年12月22日下午2:13:23
 * @version                             往内存中写数   
 * @description   new ByteArrayOutputStream() ---->返回一个byte[] date
 *                             读取数据
 *                byte[] date--------> ByteArrayInputStream 
 */
public class ByteArrayDemo01 {

	public static void main(String[] args) {
		
		byte [] date = write();
		
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

	private static byte[] write() {
		
		byte [] dest = null;
		
		//内存输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			baos.write("冬至北方要吃饺子".getBytes());
			baos.flush();

			//to.toByteArray() 把  ByteArrayOutputStream 转成了  byte []数组
			dest = baos.toByteArray();
			return dest;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtils.close(baos);
			System.out.println("写完了...");
		}
		return null;
	}
}
