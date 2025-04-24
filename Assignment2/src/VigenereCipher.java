public class VigenereCipher {

    //Function that encrypts the plaintext using the Vigenere cipher with the provided key.
    //Letters are shifted according to the key;
    public static String encrypt(String plaintext, String key) {
        String result = "";
        plaintext = plaintext.toLowerCase();
        key = key.toLowerCase();
        int keyLen = key.length();
        int keyIndex = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int shift = key.charAt(keyIndex % keyLen) - 'a';
                int newVal = (ch - 'a' + shift) % 26;
                char newCh = (char) ('a' + newVal);
                result += newCh;
                keyIndex++;
            } 
            else {
                result += ch;
            }
        }
        return result;
    }

    //Function that decrypts the ciphertext using the Vigenere cipher with the provided key.
    public static String decrypt(String ciphertext, String key) {
        String result = "";
        ciphertext = ciphertext.toLowerCase();
        key = key.toLowerCase();
        int keyLen = key.length();
        int keyIndex = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int shift = key.charAt(keyIndex % keyLen) - 'a';
                int newVal = (ch - 'a' - shift + 26) % 26;
                char newCh = (char) ('a' + newVal);
                result += newCh;
                keyIndex++;
            } 
            else {
                result += ch;
            }
        }
        return result;
    }
}
