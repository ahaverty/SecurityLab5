package ie.dit.comp.c12410858.security.calculator;

/* 
 * Linear congruential generator (LCG) with fast skipping and backward iteration
 * 
 * Copyright (c) 2014 Project Nayuki
 * All rights reserved. Contact Nayuki for licensing.
 * http://www.nayuki.io/page/fast-skipping-in-a-linear-congruential-generator
 */

import java.math.BigInteger;

public class LcgRandom {

	private final BigInteger a; // Multiplier
	private final BigInteger b; // Increment
	private final BigInteger m; // Modulus
	private final BigInteger aInv; // Multiplicative inverse of 'a' modulo m

	private BigInteger x; // State

	public LcgRandom(BigInteger a, BigInteger b, BigInteger m, BigInteger seed) {
		if (a == null || b == null || m == null || seed == null)
			throw new NullPointerException();
		if (a.signum() != 1 || b.signum() == -1 || m.signum() != 1 || seed.signum() == -1 || seed.compareTo(m) >= 0)
			throw new IllegalArgumentException("Arguments out of range");

		this.a = a;
		this.aInv = a.modInverse(m);
		this.b = b;
		this.m = m;
		this.x = seed;
	}

	public long getLong() {
		return x.longValue();
	}

	public void next() {
		x = x.multiply(a).add(b).mod(m); // x = (a*x + b) mod m
	}

	public void previous() {
		// The intermediate result after subtracting 'b' may be negative, but
		// the modular arithmetic is correct
		x = x.subtract(b).multiply(aInv).mod(m); // x = (a^-1 * (x - b)) mod m
	}

	public void skip(int n) {
		if (n >= 0)
			skip(a, b, BigInteger.valueOf(n));
		else
			skip(aInv, aInv.multiply(b).negate(), BigInteger.valueOf(n).negate());
	}

	private void skip(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger a1 = a.subtract(BigInteger.ONE); // a - 1
		BigInteger ma = a1.multiply(m); // (a - 1) * m
		BigInteger y = a.modPow(n, ma).subtract(BigInteger.ONE).divide(a1).multiply(b);
		// (a^n - 1) / (a - 1) * b, sort of
		BigInteger z = a.modPow(n, m).multiply(x); // a^n * x, sort of
		x = y.add(z).mod(m); // (y + z) mod m
	}

}
