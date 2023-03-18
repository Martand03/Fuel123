package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperationTest {

	Operation operation=new Operation();
	@Test
	public void test1()
	{
		int res=20;
		int sum=operation.add(10, 10);
		assertEquals(res, sum);
		System.out.println("Success");
	}
}
