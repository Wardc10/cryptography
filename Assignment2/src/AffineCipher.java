public class AffineCipher {

    //Computes the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    //Computes the modular inverse of a modulo m.
    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1)
                return x;
        }
        throw new IllegalArgumentException("Modular inverse does not exist for a = " + a + " and m = " + m);
    }

    //Encrypts the plaintext using the affine cipher formula: E(x) = (a * x + b) mod 26.
    public static String encrypt(String plaintext, int a, int b) {
        String result = "";
        plaintext = plaintext.toLowerCase();

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int x = ch - 'a';
                int y = (a * x + b) % 26;
                char newCh = (char) ('a' + y);
                result += newCh;
            } 
            else {
                result += ch;
            }
        }
        return result;
    }

    //Function that decrypts the ciphertext using the affine cipher decryption formula.
    public static String decrypt(String ciphertext, int a, int b) {
        if (gcd(a, 26) != 1) {
            return "Error: a is not coprime with 26.";
        }
        int a_inv = modInverse(a, 26);
        String result = "";
        ciphertext = ciphertext.toLowerCase();

        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int y = ch - 'a';
                int x = (a_inv * (y - b + 26)) % 26;
                char newCh = (char) ('a' + x);
                result += newCh;
            } 
            else {
                result += ch;
            }
        }
        return result;
    }
}
