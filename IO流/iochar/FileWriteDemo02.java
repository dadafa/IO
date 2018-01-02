/**
 * 
 */
package com.xyd.iochar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author scott
 * @date 2017年12月22日上午9:56:19
 * @version 
 * @description fileWrite 写数据 
 */
public class FileWriteDemo02 {

	public static void main(String[] args) {
		
		write("src/b.txt");
		
	}

	private static void write(String src) {
		
		File file = new File(src);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			
			//写字符串
			fw.write("中彩票了,每人过来领2万");
			
			//写char[] 数组
			fw.write("土豪一般冲公交卡都是十几万十几万冲".toCharArray());
			fw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("写入 完毕");
		}
		
		
		
	}
}
