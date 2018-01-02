/**
 * 
 */
package com.xyd.buffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author scott
 * @date 2017年12月22日上午11:06:48
 * @version
 * @description 模拟键盘输入
 */
public class ConsoleDemo01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		String msg = null;
		boolean flag = true;
		System.out.println("请输入你周末的计划?");
		// 字符缓冲 BufferedReader
		while (flag) {
			// 拿到 system 的输入流
			InputStream is = System.in;
			// 把输入字节流 转成 字符流InputStreamReader
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bw = new BufferedReader(isr);
			try {
				msg = bw.readLine();
				
				if (msg != null && msg.equals("bye")) {
					flag = false;
					System.out.println("程序结束");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			System.out.println(msg);
		}

	}
}
