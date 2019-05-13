package com.in28minutes.junit5;



public class Week2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgrammingWeek2 week2 = new ProgrammingWeek2();
		System.out.println(week2.getLastDigitOfPartialFibSum(10, 62));
		
	}

}

class ProgrammingWeek2 {
	
	
	/*
	 * Task: Given an integer, find the nth fibonacci number
	 * Input Format: The input consists of a single integer n.
	 * Constraints: n ≤ 45
	 */
	public int memFib(int n) {
		int [] fibArray = new int[n];
		fibArray[0] = 1;
		fibArray[1] = 1;
		for (int i = 2; i < n; i++) {
			fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]);
		}
		return fibArray[n - 1];
	}
	
	/*
	 * Task: Given an integer n, find the last digit of the nth fibonacci number
	 * Input Format: The input consists of a single integer n.
	 * Constraints: n = 0≤ n ≤10(exp)7.
	 * Output Format: Output the last digit of f(n)
	 * Solution: (fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]) mod 10
	 */	 
	public int lastDigitOfLargeFibonacciNumber(int n) {
		int [] fibArray = new int[n];
		fibArray[0] = 1;
		fibArray[1] = 1;
		for (int i = 2; i < n; i++) {
			fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]) % 10;
		}
		return fibArray[n - 1];
	}
	
	/*
	 * Task: Given two integers i and j, find their greatest common divisor
	 * Input Format: The two integers i, j are given in the same line separated by space.
	 * Constraints: 1≤, 1 ≤ i, j 2 ·10(exp)9
	 * Output Format: Output GCD(i, j)
	 * Solution euclidean gcd
	 */
	public int greatestCommonDivisor(int i, int j) {
		if (j == 0) return i;
		return greatestCommonDivisor(j, i % j);
	}
	
	/*
	 * Task: Given two integers i and j, find their least common multiple
	 * Input Format: The two integers i, j are given in the same line separated by space.
	 * Constraints: 1≤, 1 ≤ i, j 2 ·10(exp)9
	 * Output Format: Output LCM(i, j)
	 * Solution euclidean LCM
	 * Reference: https://en.wikipedia.org/wiki/Least_common_multiple
	 */		
	public long leastCommonMultiple(long i, long j) {
		return (i * j)/euclidGCD(i, j);
	}
	
	private long euclidGCD(long a, long b) {
		if (b == 0) return a;
		return euclidGCD(b, a % b);
	}
	
	/*
	 * Task: Given two integers n and m, output f(n) mod m
	 * Solution: find the pisano period
	 * For m= 2, the period is (0 1 1) and has length 3, while for m= 3the period is (01120221) and has length 8. 
	 * Therefore, to compute,say, f(2015)mod 3 we just need to find the remainder of2015 when divided by 8. 
	 * The length of pisano period 1000 is 1500
	 * Reference: https://en.wikipedia.org/wiki/Pisano_period
	 */		
	
	public long fibonacci_N_Modulo_M(long n, long m) {
		long a = 0;
		long b = 1;
		long rem = n % getPaisanoLength(a, b, 0, m);
		long res = 0;
		for (int i = 1; i < rem; i++) {
			res = (a + b) % m;
			a = b;
			b = res;
			
		}
		return res % m;
	}
	
	
	private long getPaisanoLength(long i, long j, long k, long m) {
		// TODO Auto-generated method stub
		long result = 0;
		for (int a = 0; a < m*m; a++) {
			k = (i + j) % m;
			i = j;
			j = k;
			if (i == 0 && j == 1) {
				result = a + 1;
				break;
			}
		}
		return result;
	}
	
	/*
	 * Task: Given an integer n,  find the sum of f(0) + f(1)...+ f(n)
	 * Solution: the last integer in any fibonacci sequence travels in period of 60
	 * 
	 * Reference: https://www.johndcook.com/blog/2015/08/04/last-digits-fibonacci-numbers/
	 */			
	public long getLastDigitOfFibonaciSum(int n) {
		if (n <= 0) 
	        return 0; 
		if (n == 1)
			return 1;
		return getFib(0, 1, 0, ((n + 2)  % 60) - 1);
	       
	       
	}
	
	private long getFib(int i, int j, long res, int n) {
		long sum = res + i;
		int next = i + j;
		i = j;
		j = next;
		if (n > 1) 
			return getFib(i, j, sum, n - 1);
		else 
			return sum % 10;
	}
	
	/*
	 * Task: Given two integer n and m,  find the sum of f(n) + f(n1)...+ f(m)
	 * Solution: the last integer in any fibonacci sequence travels in period of 60
	 * which we can use to sum up given the binet formula, if n % 60 > m % 60, simply
	 * say m += m % 60 + 60
	 * Reference:https://www.coursera.org/lecture/fibonacci/binets-formula-36WAw
	 */		
	public int getLastDigitOfPartialFibSum(int n, int m) {
	
			
		// To store the sum 
	    int sum = 0; 
		
	    if (n % 60 > m % 60) {
	    	int k = (m % 60) + 60;
	    	for(int i = n % 60; i <= k; i++)
	    		sum += binet(i);
	    }
	    
	    else {
	    // Calculate the sum 
	    	for(int i = n % 60; i <= m % 60; i++)
	    		sum += binet(i);
	    }
	    return Math.abs(sum % 10); 
	    
	}
	
	private int binet(int n) 
	{ 
		double phi = (1 + Math.sqrt(5)) / 2; 
	    return (int) Math.abs(Math.round(Math.pow(phi, n) / Math.sqrt(5)));
	} 

}


