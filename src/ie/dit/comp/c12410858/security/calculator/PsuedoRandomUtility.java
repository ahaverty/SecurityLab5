package ie.dit.comp.c12410858.security.calculator;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.apache.commons.math3.random.MersenneTwister;

public class PsuedoRandomUtility {

	public static long generateNumber(String algorithm) {
		
		SecureRandom secureRandom = null;
		
		try {
			secureRandom = SecureRandom.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("No such algorithm found");
		}
		
		return secureRandom.nextLong() & 0xffffffffL;
	}
	
	public static long generateNumberUsingMersenneTwister() {
		MersenneTwister mt = new MersenneTwister();
		return mt.nextLong() & 0xffffffffL;
	}
	
	public static long generateNumberUsingBlumBlumShub() {
		BigInteger generatedNumber = BlumBlumShub.generateN(32, new Random());
		BlumBlumShub bbs = new BlumBlumShub(generatedNumber);
		//bbs.next(numBits)
		//TODO!
		return generatedNumber.longValue();
	}
	
	public static long generateNextPrimeNumber(long primeNumber) {
		while (!isPrime(++primeNumber)) 
	    { }
		return primeNumber;
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
