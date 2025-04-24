import java.util.HashMap;
import java.util.Map;

//Problem #3
//This class provides methods to decrypt a shift cipher using the Likelihood Ratio Test (LRT).
//It includes functions to, Decrypt text for a given shift, Compute the log likelihood ratio (LLR) for a decrypted text, and Find the best shift (0–25) based on maximum LLR
public class LRT {

    //Used the frequency table in slides 1. 
    public Map<Character, Double> frequency = new HashMap<>();
    {
        frequency.put('A', 0.0812);
        frequency.put('B', 0.0149);
        frequency.put('C', 0.0271);
        frequency.put('D', 0.0432);
        frequency.put('E', 0.1202);
        frequency.put('F', 0.0230);
        frequency.put('G', 0.0203);
        frequency.put('H', 0.0592);
        frequency.put('I', 0.0731);
        frequency.put('J', 0.0010);
        frequency.put('K', 0.0069);
        frequency.put('L', 0.0398);
        frequency.put('M', 0.0261);
        frequency.put('N', 0.0695);
        frequency.put('O', 0.0768);
        frequency.put('P', 0.0182);
        frequency.put('Q', 0.0011);
        frequency.put('R', 0.0602);
        frequency.put('S', 0.0628);
        frequency.put('T', 0.0910);
        frequency.put('U', 0.0288);
        frequency.put('V', 0.0111);
        frequency.put('W', 0.0209);
        frequency.put('X', 0.0017);
        frequency.put('Y', 0.0211);
        frequency.put('Z', 0.0007);
    }
    
    //Uniform noise probability for each letter (assumed for noise distribution)
    public double NOISE_PROB = 1.0 / 26;

   
    public String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();
        for(char ch : ciphertext.toCharArray()) {
            if(Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                int pos = upper - 'A';
                int newPos = (pos - shift + 26) % 26;
                char dec = (char) ('A' + newPos);
                plaintext.append(dec);
            } 
            else {
                //Preserve non-letter characters.
                plaintext.append(ch);
            }
        }
        return plaintext.toString();
    }

    //Computes the log likelihood ratio (LLR) for the given plaintext.
    public double computeLLR(String plaintext) {
        double llr = 0.0;
        for(char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                double pE = frequency.getOrDefault(upper, NOISE_PROB);
                llr += Math.log(pE / NOISE_PROB);
            }
        }
        return llr;
    }

    //Finds the best shift (0–25) that maximizes the LLR.
    public int findBestShift(String ciphertext) {
        double maxLLR = Double.NEGATIVE_INFINITY;
        int bestShift = 0;
        for(int shift = 0; shift < 26; shift++) {
            String decrypted = decrypt(ciphertext, shift);
            double llr = computeLLR(decrypted);
            if(llr > maxLLR) {
                maxLLR = llr;
                bestShift = shift;
            }
        }
        return bestShift;
    }

    public String getDecryptedText(String ciphertext, int shift) {
        return decrypt(ciphertext, shift);
    }

    public void runShiftCipherDecryption() {
        String ciphertext = "gyznkjgeycktzheznkkburazoutulroqkotzurubkcgygiikrkxgzkjcnozklgtmnosykrlhkmgtzumxckjatikgyotmreucgcgxkulozznuamnotnoyiutyiouaytkyynkqtkctuzcngzrubkcgyozsgtolkyzkjozykrlzunosgygbuojotnoyhkotmgnatmxeginotmekgxtotmbuojzngzirgsuaxkjzuhklorrkjozcgygvgotgtjgtatxkyzgtjozxkikobkjkgyksktzutreheznkzuainulznktkcmujoyvxkyktikgzyainzoskyrubkcgypuezunosgcorjqkktznxorrotmygzoylgizouthazcnktgcgelxusnoymujznkvgotgtjznkatxkyzxkzaxtkjznkbuojotnosyvxgtmavgtjvxkyykjgmgotyznoscoznozyksvzotkyygtjznknatmkxmtgckjgtjmtg";
        int bestShift = findBestShift(ciphertext);
        String decryptedText = getDecryptedText(ciphertext, bestShift);
        System.out.println("Problem 3:");
        System.out.println("Best shift: " + bestShift);
        System.out.println("Decrypted text:");
        System.out.println(decryptedText);
        System.out.println();
    }
}
