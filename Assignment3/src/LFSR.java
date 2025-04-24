//Problem #1
//This class finds an LFSR configuration that produces a keystream that matches our known keystream.
//It uses brute force by testing combinations of degree (m), feedback coefficients, and initial state

public class LFSR {

    public int[] findLfsrThatMatches(String K) {
        int len = K.length();
        int[] Kbits = toBitArray(K);
        for (int m = 1; m <= 9; m++) {
            // 2^m possibilities for both feedback coefficients and initial state.
            int limit = 1 << m; 
            for (int feedback = 0; feedback < limit; feedback++) {
                for (int init = 0; init < limit; init++) {
                    int[] seq = lfsrGenerate(m, feedback, init, len);
                    if (matches(seq, Kbits)) {
                        return new int[]{m, feedback, init};
                    }
                }
            }
        }
        return null;
    }

    
 //Generates a sequence of bits from an m-bit LFSR using the provided feedback and initial state.
//m is the degree (number of bits) of the LFSR.
//feedback is the integer representing the results of the feedback coefficients used in the XOR.

    public int[] lfsrGenerate(int m, int feedback, int initState, int length) {
        int reg = initState;
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            //Output is the least significant bit.
            output[i] = reg & 1;
            int fb = 0;
            //Compute the feedback by XORing bits indicated by the feedback coefficients.
            for (int b = 0; b < m; b++) {
                if (((feedback >> b) & 1) == 1) {
                    fb ^= ((reg >> b) & 1);
                }
            }
            reg >>= 1;
            reg |= (fb << (m - 1));
        }
        return output;
    }

    //Converts a string of bits (e.g., "001011...") to an array of integers.
    public int[] toBitArray(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = (s.charAt(i) == '1') ? 1 : 0;
        }
        return arr;
    }

    //Compares two arrays of bits.
    public boolean matches(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public void runLFSR() {
        String knownKeystream = "0010111001011100101110010111"; // 28-bit keystream
        int[] result = findLfsrThatMatches(knownKeystream);
        System.out.println("Problem 1:");

        int m = result[0];
        int feedback = result[1];
        int initState = result[2];

        System.out.println("degree m = " + m);
        System.out.println("Feedback = " + Integer.toBinaryString(feedback));
        System.out.println("Initial state = " + Integer.toBinaryString(initState));
        System.out.println();
    }
}
