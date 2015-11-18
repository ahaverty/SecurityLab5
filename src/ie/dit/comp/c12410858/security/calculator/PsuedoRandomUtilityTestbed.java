package ie.dit.comp.c12410858.security.calculator;

public class PsuedoRandomUtilityTestbed {

	public static void main(String[] args) {
		
		for(int i = 0; i < 1000; i++){
//			long sha1GeneratedNumber = PsuedoRandomUtility.generateNumber("SHA1PRNG");
//			if(PsuedoRandomUtility.isPrime(sha1GeneratedNumber)){
//				System.out.println(i + "\tSHA1PRNG:\t" + sha1GeneratedNumber + "\tisPrime:\t" + PsuedoRandomUtility.isPrime(sha1GeneratedNumber));
//			}
//			
//			long nativeGeneratedNumber = PsuedoRandomUtility.generateNumber("Windows-PRNG");
//			if(PsuedoRandomUtility.isPrime(nativeGeneratedNumber)){
//				System.out.println(i + "\tNativePRNG:\t" + nativeGeneratedNumber + "\tisPrime:\t" + PsuedoRandomUtility.isPrime(nativeGeneratedNumber));
//			}
//			
//			long bbsGeneratedNumber = PsuedoRandomUtility.generateNumberUsingBlumBlumShub();
//			if(PsuedoRandomUtility.isPrime(bbsGeneratedNumber)){
//				System.out.println(i + "\tBbsPRNG:\t" + bbsGeneratedNumber + "\tisPrime:\t" + PsuedoRandomUtility.isPrime(bbsGeneratedNumber));
//			}
			
			long mtGeneratedNumber = PsuedoRandomUtility.generateNumberUsingMersenneTwister();
			if(PsuedoRandomUtility.isPrime(mtGeneratedNumber)){
				//System.out.println(i + "\tmtPRNG:\t" + mtGeneratedNumber + "\tisPrime:\t" + PsuedoRandomUtility.isPrime(mtGeneratedNumber));
				System.out.println(i + "\tmtPRNG:\t" + mtGeneratedNumber + "\tisPrime:\tTrue");
				System.out.println(i + "a\tNextPrime:\t" + PsuedoRandomUtility.generateNextPrimeNumber(mtGeneratedNumber));
			}
			
		}
		System.out.println("Complete!");
	}

}
