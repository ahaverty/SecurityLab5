package ie.dit.comp.c12410858.security.calculator;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.math3.random.MersenneTwister;

/**
 * Utility class for generating random numbers using various algorithms. Also
 * functions for checking if prime and calculating the next prime number
 * 
 * @author Alan
 *
 */
public class PsuedoRandomUtility {

	/**
	 * Generate a random long using a SecureRandom instance (e.g. SHA1PRNG,
	 * Windows-PRNG..)
	 * 
	 * @param algorithm
	 * @return
	 * @author Alan
	 */
	public static long generateNumber(String algorithm) {

		SecureRandom secureRandom = null;

		try {
			// Set the instance/algorithm to use
			secureRandom = SecureRandom.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("No such algorithm found");
		}
		// Convert the unsigned result to a signed long
		return secureRandom.nextLong() & 0xffffffffL;
	}

	/**
	 * Generate a random long using the Mersenne Twister implementation from
	 * Apache Commons Math library
	 * 
	 * @return A random long
	 * @author Alan
	 */
	public static long generateNumberUsingMersenneTwister() {
		MersenneTwister mt = new MersenneTwister();
		// Convert the unsigned result, from the MersenneTwister class, to a
		// signed result
		return mt.nextLong() & 0xffffffffL;
	}

	/**
	 * Generate a random long using the Linear congruential generator
	 * 
	 * @return A random long
	 * @author Alan
	 */
	public static long generateNumberUsingLcg() {
		// Setting the multiplier, incrementer and seed for the LCG algorithm
		// Using the same parameters that the inbuilt java random class uses
		final BigInteger A = BigInteger.valueOf(25214903917L);
		final BigInteger B = BigInteger.valueOf(11);
		final BigInteger M = BigInteger.ONE.shiftLeft(48); // 2^48

		// Create seed using system time and a random number
		int random = new Random().nextInt();
		BigInteger seed = BigInteger.valueOf(System.currentTimeMillis() + random);

		// Instanciate the LCG generator
		LcgRandom randSlow = new LcgRandom(A, B, M, seed);

		// Convert the unsigned result to a signed long
		return randSlow.getLong() & 0xffffffffL;
	}

	/**
	 * Given n, find the next number that is prime
	 * 
	 * @param primeNumber
	 * @return the next prime number
	 */
	public static long generateNextPrimeNumber(long n) {
		//Iterate up until a prime is found, then return
		while (!isPrime(++n)) {
		}
		return n;
	}

	/**
	 * Test if n is prime
	 * 
	 * @param n
	 * @return True if n is prime, otherwise false
	 */
	public static boolean isPrime(long n) {
		if (n > 2 && (n & 1) == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

}
