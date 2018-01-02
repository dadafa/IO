/**
 * 
 */
package com.xyd.iochar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author scott
 * @date 2017年12月22日上午9:44:37
 * @version
 * @description 字符流 读取 文件
 * 
 *              1.建立联系 2.选择流 3.操作 4.关闭
 * 
 */
public class FileReaderDemo01 {

	public static void main(String[] args) {

		String msg = read("src/a.txt");
		
		System.out.println(msg);

	}

	private static String read(String srcPath) {

		// 1.建立联系
		File file = new File(srcPath);

		// 2.选择流 FileReader
		FileReader fr = null;
		try {
			fr = new FileReader(file);

			// 操作 读取字符 char[] 数组
			char[] chs = new char[1024];
			int len = 0;

			// len = fr.read(chs) 返回读入缓冲的字节总数，-1如果没有更多的数据，因为已经到达文件末尾。
			StringBuilder sb = new StringBuilder();

			while ((len = fr.read(chs)) != -1) {
				// chs 转成字符串
				String str = new String(chs, 0, len);
				//字符串 拼接
				sb.append(str);
			}
			return sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
