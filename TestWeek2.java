package com.in28minutes.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * Tests are performed to see that the alghoritms is correct and runs fast
 * No tests are performed based on wrong input values and so forth
 */

class TestWeek2 {
	
		
	@Test
	@DisplayName("Test mem fib")
	public void checkMemFibTest() {
		ProgrammingWeek2 week2 = new ProgrammingWeek2();
		assertEquals(55, week2.memFib(10));
			
	}
	
	@Test
	@DisplayName("Last Digit of large fibonacci number")
	public void lastDigitOfLargeFibonacciNumberTest() {
		ProgrammingWeek2 week2 = new ProgrammingWeek2();
		assertEquals(2, week2.lastDigitOfLargeFibonacciNumber(3));
		assertEquals(9, week2.lastDigitOfLargeFibonacciNumber(331));
		assertEquals(5, week2.lastDigitOfLargeFibonacciNumber(327305));
	}
	
	@Test
	@DisplayName("Test euclid gcd")
	public void greatestCommonDivisorTest() {
		ProgrammingWeek2 week2 = new ProgrammingWeek2();
		assertEquals(1, week2.greatestCommonDivisor(18, 35));
		assertEquals(17657, week2.greatestCommonDivisor(28851538, 1183019));	
	}
	
	@Test
	@DisplayName("Test euclid lcm")
	public void leastCommonMultipleTest() {
		ProgrammingWeek2 week2 = new ProgrammingWeek2();
		assertEquals(24, week2.leastCommonMultiple(6, 8));
		assertEquals(1933053046, week2.leastCommonMultiple(28851538, 1183019));	
	}
	
	@Test
	@DisplayName("Test modulo m of F(n)")
	public void fibonacci_N_Modulo_MTest() {
		ProgrammingWeek2 week2 = new ProgrammingWeek2();
		assertEquals(161, week2.fibonacci_N_Modulo_M(239, 1000));
		assertEquals(151, week2.fibonacci_N_Modulo_M(2816213588L, 239));	
	}
	
	@Test
	@DisplayName("Last digit of S(F(n))")
	public void getLastDigitOfFibonaciSumTest() {
		ProgrammingWeek2 week2 = new ProgrammingWeek2();
		assertEquals(4, week2.getLastDigitOfFibonaciSum(3));
		assertEquals(5, week2.getLastDigitOfFibonaciSum(100));	
	}
	
	@Test
	@DisplayName("Last digit of Sum in range(F(n, m))")
	public void LastDigitOfPartialFibSumTest() {
		ProgrammingWeek2 week2 = new ProgrammingWeek2();
		assertEquals(1, week2.getLastDigitOfPartialFibSum(3, 7));
		assertEquals(5, week2.getLastDigitOfPartialFibSum(10, 10));
		assertEquals(2, week2.getLastDigitOfPartialFibSum(10, 200));
	}

}
