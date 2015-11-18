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
	
	public static long generateNumberUsingLcg() {
		// Use the parameters from Java's LCG RNG
		final BigInteger A = BigInteger.valueOf(25214903917L);
		final BigInteger B = BigInteger.valueOf(11);
		final BigInteger M = BigInteger.ONE.shiftLeft(48);  // 2^48
		
		// Choose seed and create LCG RNG
		int random = new Random().nextInt();
		BigInteger seed = BigInteger.valueOf(System.currentTimeMillis() + random);
		LcgRandom randSlow = new LcgRandom(A, B, M, seed);
		
		return randSlow.getState() & 0xffffffffL;
	}
	
	public static long generateNumberUsingBlumBlumShub() {
		double p = new Random().nextDouble();
		double q = new Random().nextDouble();
		double seed = new Random().nextDouble();
		BlumBlumShub bbs = new BlumBlumShub(p,q,seed);
		
		return (long) bbs.getRandom();
	}
	
	public static long generateNextPrimeNumber(long primeNumber) {
		while (!isPrime(++primeNumber)) 
	    { System.out.println("In while loop. " + primeNumber);}
		System.out.println("Done....");
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
