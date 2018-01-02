/**
 * 
 */
package com.xyd.mydecotor;

/**
 * @author scott
 * @date 2017年12月22日下午4:32:53
 * @version 
 * @description 
 */
public class BufferedCar extends Car{

	Car car;
	
	public BufferedCar(Car car) {
		super();
		this.car = car;
	}



	@Override
	public void run() {
		car.run();
		buffered();
	}

	private void buffered() {
		System.out.println("汽车功能价加强了...");
	}

}
