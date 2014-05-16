package com.learning.myweb.test;

public class Test {

	public static void main(String[] args) {

		System.out.println(Runtime.getRuntime().availableProcessors());
		TestStringClass<String> s = new TestStringClass<String>();
		
		System.out.println(s.getIntvalue());
	}
	

}
