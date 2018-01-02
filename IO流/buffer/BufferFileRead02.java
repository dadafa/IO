/**
 * 
 */
package com.xyd.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.xyd.IOUtils;

/**
 * @author scott
 * @date 2017年12月22日上午10:52:23
 * @version
 * @description 字符缓冲流 新增方法 readLine() newLine() new
 *              BufferedReader(read(FileReader))
 */
public class BufferFileRead02 {

	public static void main(String[] args) {

		write("src/c.txt");

		read("src/c.txt");

	}

	private static void write(String path) {

		File file = new File(path);

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(file));

			bw.write("白日依山尽\r\n");
			bw.write("黄河入海流");
			bw.newLine();
			bw.write("欲穷千里目"); // 新增方法 换行
			bw.newLine();

			bw.write("快来学java");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.close(bw);
		}

	}

	private static void read(String path) {
		File file = new File(path);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));

			String msg = null;

			//新增方法  读取一行  readLine();
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
			}

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
