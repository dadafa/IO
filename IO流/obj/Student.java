/**
 * 
 */
package com.xyd.obj;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author scott
 * @date 2017年12月22日下午2:50:00
 * @version 
 * @description   java.io.NotSerializableException: 
 *      com.xyd.obj.Student 报错信息(写入的对象没有实现 序列化) 类实现序列化接口（Serializable）
 */
public class Student implements Serializable{

	//transient  加了 这个 不能实现 序列化
	//1. 被transient关键字修饰的成员变量不再能被序列化。
    //2. 静态变量不管是否被transient修饰，均不能被序列化。

	private transient int age;
	
	private String name;
	
	private int score;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student(int age, String name, int score) {
		this.age = age;
		this.name = name;
		this.score = score;
	}
	
	public Student() {
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", score=" + score + "]";
	}
	
	
}
