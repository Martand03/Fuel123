package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class Demo {

	@Before
	public void d()
	{
		System.out.println("before each method");
	}
	@After
	public void d1()
	{
		System.out.println("after each method");
	}
	@Test
	public void demo()
	{
		String string="MIT";
		String string2="MIT";
		assertEquals(string,string2 );
		System.out.println("Sucess");
	}
	@Ignore
	@Test
	public void demo1()
	{
		System.out.println("sucess1 ");
	}
}
