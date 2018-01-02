/**
 * 
 */
package com.xyd.mydecotor;

/**
 * @author scott
 * @date 2017年12月22日下午4:36:06
 * @version 
 * @description 
 *    FileinputStream  读取的功能
 *    
 *    BufferedInputstream(new fis)  功能加强了 (效率高  有缓冲流)  
 *    
 * 
 */
public class Client {

	public static void main(String[] args) {
		Car car = new BufferedCar(new WaterCar());
		car.run();
		
		System.out.println("****************");
		
		Car car1 = new BufferedCar(new FlyCar());
		car1.run();
	}
}
