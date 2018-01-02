/**
 * 
 */
package com.xyd.buffer;

/**
 * @author scott
 * @date 2017年12月22日上午11:29:52
 * @version 
 * @description 
 */
public class Test01 {

	public static void main(String[] args) {
		
		String binaryString = Integer.toBinaryString(3);
		System.out.println(binaryString);
		
		
		String s = "";
		for (int i = 5; i > 0; i/=2) {
			s = (i % 2 )+s;
		}
		System.out.println(s);
		
	}
}
