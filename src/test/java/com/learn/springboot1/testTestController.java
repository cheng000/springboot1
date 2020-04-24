package com.learn.springboot1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testTestController {

	@Before
	public void setUp() throws Exception {
		System.out.println("start!");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("end");
	}

	@Test
	public void test() {
		
	}

}
