package ie.dit.comp.c12410858.security.calculator;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PsuedoRandomUtility {

	public static long generateNumber(String algorithm) {
		
		SecureRandom secureRandom = null;
		
		try {
			secureRandom = SecureRandom.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("No such algorithm found");
		}
		
		long generatedNumber = secureRandom.nextLong() & 0xffffffffL;
		
		return generatedNumber;
	}
	
	/**
	 * Test if n is prime
	 * @param n
	 * @return True if n is prime, otherwise false
	 */
	public static boolean isPrime(long n) {
	    if(n > 2 && (n & 1) == 0)
	       return false;
	    for(int i = 3; i * i <= n; i += 2)
	        if (n % i == 0) 
	            return false;
	    return true;
	}
	
}
