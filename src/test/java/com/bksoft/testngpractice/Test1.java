package com.bksoft.testngpractice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	
	@BeforeTest
	public void beforTest() {
		System.out.println("Test1 Before Test Executed");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Test1 Before method executed");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Test1 Before class");
	}
	
	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test3");
	}

}
