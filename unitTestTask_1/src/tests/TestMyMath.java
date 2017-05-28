package tests;

import org.junit.Test;

import arithmetic.MyMath;

import static org.junit.Assert.*;


public class TestMyMath {
	
	@Test
	public void testAdd () {
		
		int a = 10;
		int b = 2;
		
		int expected = 12;
		int result = MyMath.add(a, b);
		
		assertEquals(expected, result, 0);
	
	}
	
	@Test
	public void testSubtract () {
		
		int a = 12;
		int b = 10;
		
		int expected = 2;
		int result = MyMath.subtract(a, b);
		
		assertEquals(expected, result, 0);
	
	}
	
	@Test
	public void testMultiply () {
		
		int a = 5;
		int b = 2;
		
		int expected = 10;
		int result = MyMath.multiply(a, b);
		
		assertEquals(expected, result, 0);
	
	}
}