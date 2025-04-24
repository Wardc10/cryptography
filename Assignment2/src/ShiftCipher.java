public class ShiftCipher {

    // Function that encrypts the given plaintext using a shift cipher.
    public static String encrypt(String plaintext, int shift) {
        String result = "";
        shift = shift % 26;

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int newVal = (ch - 'a' + shift) % 26;
                char newCh = (char) ('a' + newVal);
                result += newCh;
            } 
            else if (ch >= 'A' && ch <= 'Z') {
                int newVal = (ch - 'A' + shift) % 26;
                char newCh = (char) ('A' + newVal);
                result += newCh;
            } 
            else {
                result += ch;
            }
        }
        return result;
    }

    //Function that decrypts the given ciphertext using a shift cipher.
    public static String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, 26 - (shift % 26));
    }
}
