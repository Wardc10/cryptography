public class Tester {

    public Tester(){

    }

    FrequencyAnalyzer fa = new FrequencyAnalyzer();

    public void testFrequencyAnalyzer(String sampleText){
        // Frequency Analysis of a sample text.
        
        System.out.println("=== Frequency Analysis ===");
        fa.relativeFrequency(sampleText);
        System.out.println();

    }

    public void testShiftCipher(String shiftPlaintext, String givenCiphertext, String sampleText){
        //Shift Cipher Encryption and Decryption.
        //Chosen shift key.
        int shiftKey = 4;
        String shiftEncrypted = ShiftCipher.encrypt(shiftPlaintext, shiftKey);
        System.out.println("=== Shift Cipher ===");
        System.out.println("Original Text: " + shiftPlaintext);
        System.out.println("Encrypted Text (key = " + shiftKey + "): " + shiftEncrypted);
        
        String shiftDecrypted = ShiftCipher.decrypt(shiftEncrypted, shiftKey);
        System.out.println("Decrypted Text: " + shiftDecrypted);
        System.out.println();

        //Detect shift key using frequency analysis and decrypt the given ciphertext.
        int detectedShift = fa.detectShiftKey(givenCiphertext, sampleText);
        String decryptedGiven = ShiftCipher.decrypt(givenCiphertext, detectedShift);
        System.out.println("=== Given Shift Cipher Decryption ===");
        System.out.println("Given Ciphertext: " + givenCiphertext);
        System.out.println("Detected Shift: " + detectedShift);
        System.out.println("Decrypted Given Ciphertext: " + decryptedGiven);
        System.out.println();
    }

    public void testAffineCipher(String affinePlaintext, int a, int b){
        String affineEncrypted = AffineCipher.encrypt(affinePlaintext, a, b);
        System.out.println("=== Affine Cipher ===");
        System.out.println("Original Text: " + affinePlaintext);
        System.out.println("Encrypted Text (a = " + a + ", b = " + b + "): " + affineEncrypted);
        
        String affineDecrypted = AffineCipher.decrypt(affineEncrypted, a, b);
        System.out.println("Decrypted Text: " + affineDecrypted);
        System.out.println();
    }

    public void testVigenereCipher(String vigenerePlaintext, String vigenereKey){
        String vigenereEncrypted = VigenereCipher.encrypt(vigenerePlaintext, vigenereKey);
        System.out.println("=== Vigenere Cipher ===");
        System.out.println("Original Text: " + vigenerePlaintext + "\n");
        System.out.println("Encrypted Text (key = \"" + vigenereKey + "\"): " + vigenereEncrypted + "\n");
        
        String vigenereDecrypted = VigenereCipher.decrypt(vigenereEncrypted, vigenereKey);
        System.out.println("Decrypted Text: " + vigenereDecrypted + "\n");
    }

}
