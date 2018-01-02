/**
 * 
 */
package com.xyd;

import java.util.Collections;

/**
 * @author scott
 * @date 2017年12月21日下午5:13:37
 * @version 
 * @description 
 */
public class IOUtils {

	public static void close(AutoCloseable ... ios) {
		
		for (AutoCloseable autoCloseable : ios) {
			if (autoCloseable != null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
//	public static <T extends AutoCloseable>  void closeAll(T  ... t) {
//		
//		for (T a: t) {
//			if (a != null) {
//				try {
//					a.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}
