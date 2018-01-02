/**
 * 
 */
package com.xyd.buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.xyd.IOUtils;

/**
 * @author scott
 * @date 2017年12月22日上午10:52:23
 * @version 
 * @description  字符缓冲流  
 *               new BufferedReader(read(FileReader))
 */
public class BufferFileRead {

	public static void main(String[] args) {
		

		read("d:/b.txt");
		
		
	}

	private static void read(String path) {
		
		File file = new File(path);
		
		BufferedReader br =null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			char [] chs = new char[1024];
			int len = 0;
			StringBuilder sb = new StringBuilder();
			while ((len = br.read(chs)) != - 1) {
					String string = new String(chs, 0, len);
					sb.append(string);
			}
			System.out.println(sb.toString());
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.close(br);
		}
		
	}
}
