package ie.dit.comp.c12410858.security.calculator;

public class PsuedoRandomUtilityTestbed {

	public static void main(String[] args) {
		
		for(int i = 0; i < 1000; i++){
			long sha1GeneratedNumber = PsuedoRandomUtility.generateNumber("SHA1PRNG");
			System.out.println("SHA1PRNG:\t" + sha1GeneratedNumber + "\tisPrime:\t" + PsuedoRandomUtility.isPrime(sha1GeneratedNumber));
			
			long nativeGeneratedNumber = PsuedoRandomUtility.generateNumber("Windows-PRNG");
			System.out.println("NativePRNG:\t" + nativeGeneratedNumber + "\tisPrime:\t" + PsuedoRandomUtility.isPrime(nativeGeneratedNumber));
		}
	}

}
