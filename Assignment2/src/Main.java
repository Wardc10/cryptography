public class Main {
    public static void main(String[] args) {
        
        Tester test = new Tester();

        String sampleText = "This is a sample message used to compute the relative frequencies of letters in a given text.";

        //Prints the results of a Frequency Analysis on a given text.
        test.testFrequencyAnalyzer(sampleText);

        //plain text used to test encrpytion of Shift Cipher algorithm.
        String shiftPlaintext = "this is a plaintext message for the shift cipher.";
        //given cipher text to decrypt from problem 2.
        String givenCiphertext = "xultpaajcxitltlxaarpjhtiwtgxktghidhipxciwtvgtpilpitghlxiwiwtxgqadds.";
        //Prints the results of the Shift Cipher example on a given text.
        test.testShiftCipher(shiftPlaintext, givenCiphertext, sampleText);

        //Prints the results of the Affine Cipher on a given text.
        String affinePlaintext = "this is a plaintext message for the affine cipher.";
        //gcd of a and 26 should be 1 for this to work.
        int a = 3, b = 5;
        test.testAffineCipher(affinePlaintext, a, b);
       
        //plaintext given in problem 4
        String vigenerePlaintext = "Hellenism was the combination of Greek, Persian, and Egyptian cultures. During this remarkable time period people were encouraged to pursue a formal education and produce many different kinds of art. New forms of math, science, and design made a great impact on society.";
        String vigenereKey1 = "keyone";
        String vigenereKey2 = "secondkey";
        //Two test methods with two different keys as specified in problem 4.
        test.testVigenereCipher(vigenerePlaintext, vigenereKey1);
        test.testVigenereCipher(vigenerePlaintext, vigenereKey2);
        
    }
}
