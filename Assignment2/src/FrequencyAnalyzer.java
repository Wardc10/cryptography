public class FrequencyAnalyzer {

    //Function that computes the relative frequency of each letter (a–z) of the given text. 
    public void relativeFrequency(String text){
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0, countF = 0, countG = 0, countH = 0;
        int countI = 0, countJ = 0, countK = 0, countL = 0, countM = 0, countN = 0, countO = 0, countP = 0;
        int countQ = 0, countR = 0, countS = 0, countT = 0, countU = 0, countV = 0, countW = 0, countX = 0;
        int countY = 0, countZ = 0;
        int totalLetters = 0;

        text = text.toLowerCase();

        //Count each letter
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                totalLetters++;
                if (ch == 'a'){
                    countA++;
                }
                else if (ch == 'b'){
                    countB++;
                } 
                else if (ch == 'c'){
                    countC++;
                } 
                else if (ch == 'd'){
                    countD++;
                }
                else if (ch == 'e'){
                    countE++;
                }
                else if (ch == 'f'){
                    countF++;
                }
                else if (ch == 'g'){
                    countG++;
                }
                else if (ch == 'h'){
                    countH++;
                }
                else if (ch == 'i'){
                    countI++;
                }
                else if (ch == 'j'){
                    countJ++;
                }
                else if (ch == 'k'){
                    countK++;
                }
                else if (ch == 'l'){
                    countL++;
                }
                else if (ch == 'm'){
                    countM++;
                }
                else if (ch == 'n'){
                    countN++;
                }
                else if (ch == 'o'){
                    countO++;
                }
                else if (ch == 'p'){
                    countP++;
                }
                else if (ch == 'q'){
                    countQ++;
                }
                else if (ch == 'r'){
                    countR++;
                }
                else if (ch == 's'){
                    countS++;
                }
                else if (ch == 't'){
                    countT++;
                }
                else if (ch == 'u'){
                    countU++;
                }
                else if (ch == 'v'){
                    countV++;
                }
                else if (ch == 'w'){
                    countW++;
                }
                else if (ch == 'x'){
                    countX++;
                }
                else if (ch == 'y'){
                    countY++;
                }
                else if (ch == 'z'){
                    countZ++;
                }
            }
        }

        if (totalLetters == 0) {
            System.out.println("No letters found in the text.");
            return;
        }

        System.out.println("Relative Frequencies (Total letters: " + totalLetters + "):");
        System.out.printf("a: %.4f%n", (double) countA / totalLetters);
        System.out.printf("b: %.4f%n", (double) countB / totalLetters);
        System.out.printf("c: %.4f%n", (double) countC / totalLetters);
        System.out.printf("d: %.4f%n", (double) countD / totalLetters);
        System.out.printf("e: %.4f%n", (double) countE / totalLetters);
        System.out.printf("f: %.4f%n", (double) countF / totalLetters);
        System.out.printf("g: %.4f%n", (double) countG / totalLetters);
        System.out.printf("h: %.4f%n", (double) countH / totalLetters);
        System.out.printf("i: %.4f%n", (double) countI / totalLetters);
        System.out.printf("j: %.4f%n", (double) countJ / totalLetters);
        System.out.printf("k: %.4f%n", (double) countK / totalLetters);
        System.out.printf("l: %.4f%n", (double) countL / totalLetters);
        System.out.printf("m: %.4f%n", (double) countM / totalLetters);
        System.out.printf("n: %.4f%n", (double) countN / totalLetters);
        System.out.printf("o: %.4f%n", (double) countO / totalLetters);
        System.out.printf("p: %.4f%n", (double) countP / totalLetters);
        System.out.printf("q: %.4f%n", (double) countQ / totalLetters);
        System.out.printf("r: %.4f%n", (double) countR / totalLetters);
        System.out.printf("s: %.4f%n", (double) countS / totalLetters);
        System.out.printf("t: %.4f%n", (double) countT / totalLetters);
        System.out.printf("u: %.4f%n", (double) countU / totalLetters);
        System.out.printf("v: %.4f%n", (double) countV / totalLetters);
        System.out.printf("w: %.4f%n", (double) countW / totalLetters);
        System.out.printf("x: %.4f%n", (double) countX / totalLetters);
        System.out.printf("y: %.4f%n", (double) countY / totalLetters);
        System.out.printf("z: %.4f%n", (double) countZ / totalLetters);
    }

    
    //Function that computes the most frequenct letter (a–z) in the given text.
    //I made a separate function so it's possible to calculate the most frequent letter without doing a full frequency analysis.
    public char mostFrequentLetter(String text) {
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0, countF = 0, countG = 0, countH = 0;
        int countI = 0, countJ = 0, countK = 0, countL = 0, countM = 0, countN = 0, countO = 0, countP = 0;
        int countQ = 0, countR = 0, countS = 0, countT = 0, countU = 0, countV = 0, countW = 0, countX = 0;
        int countY = 0, countZ = 0;

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a') {
                    countA++;
                }
                else if (ch == 'b'){
                    countB++;
                } 
                else if (ch == 'c'){
                    countC++;
                } 
                else if (ch == 'd'){
                    countD++;
                }
                else if (ch == 'e'){
                    countE++;
                }
                else if (ch == 'f'){
                    countF++;
                }
                else if (ch == 'g'){
                    countG++;
                }
                else if (ch == 'h'){
                    countH++;
                }
                else if (ch == 'i'){
                    countI++;
                }
                else if (ch == 'j'){
                    countJ++;
                }
                else if (ch == 'k'){
                    countK++;
                }
                else if (ch == 'l'){
                    countL++;
                }
                else if (ch == 'm'){
                    countM++;
                }
                else if (ch == 'n'){
                    countN++;
                }
                else if (ch == 'o'){
                    countO++;
                }
                else if (ch == 'p'){
                    countP++;
                }
                else if (ch == 'q'){
                    countQ++;
                }
                else if (ch == 'r'){
                    countR++;
                }
                else if (ch == 's'){
                    countS++;
                }
                else if (ch == 't'){
                    countT++;
                }
                else if (ch == 'u'){
                    countU++;
                }
                else if (ch == 'v'){
                    countV++;
                }
                else if (ch == 'w'){
                    countW++;
                }
                else if (ch == 'x'){
                    countX++;
                }
                else if (ch == 'y'){
                    countY++;
                }
                else if (ch == 'z'){
                    countZ++;
                }
            }
        }

        int max = countA;
        char mostFreq = 'a';
        if (countB > max) { 
            max = countB; 
            mostFreq = 'b'; 
        }
        if (countC > max) { 
            max = countC; 
            mostFreq = 'c'; 
        }
        if (countD > max) { 
            max = countD; 
            mostFreq = 'd'; 
        }
        if (countE > max) { 
            max = countE; 
            mostFreq = 'e'; 
        }
        if (countF > max) { 
            max = countF; 
            mostFreq = 'f'; 
        }
        if (countG > max) { 
            max = countG; 
            mostFreq = 'g'; 
        }
        if (countH > max) { 
            max = countH; 
            mostFreq = 'h'; 
        }
        if (countI > max) { 
            max = countI; 
            mostFreq = 'i'; 
        }
        if (countJ > max) { 
            max = countJ; 
            mostFreq = 'j'; 
        }
        if (countK > max) { 
            max = countK; 
            mostFreq = 'k'; 
        }
        if (countL > max) { 
            max = countL; 
            mostFreq = 'l'; 
        }
        if (countM > max) { 
            max = countM; 
            mostFreq = 'm'; 
        }
        if (countN > max) { 
            max = countN; 
            mostFreq = 'n'; 
        }
        if (countO > max) { 
            max = countO; 
            mostFreq = 'o'; 
        }
        if (countP > max) { 
            max = countP; 
            mostFreq = 'p'; 
        }
        if (countQ > max) { 
            max = countQ; 
            mostFreq = 'q'; 
        }
        if (countR > max) { 
            max = countR; 
            mostFreq = 'r'; 
        }
        if (countS > max) { 
            max = countS; 
            mostFreq = 's'; 
        }
        if (countT > max) { 
            max = countT; 
            mostFreq = 't'; 
        }
        if (countU > max) {
            max = countU; 
            mostFreq = 'u'; 
        }
        if (countV > max) { 
            max = countV; 
            mostFreq = 'v'; 
        }
        if (countW > max) { 
            max = countW; 
            mostFreq = 'w'; 
        }
        if (countX > max) { 
            max = countX; 
            mostFreq = 'x'; 
        }
        if (countY > max) { 
            max = countY; 
            mostFreq = 'y'; 
        }
        if (countZ > max) { 
            max = countZ; 
            mostFreq = 'z'; 
        }

        return mostFreq;
    }

    //Uses frequency analysis (assuming that the most frequent letter in the ciphertext corresponds to the most frequent in the sampleText to detect a shift key.
    public int detectShiftKey(String ciphertext, String sampleText) {
        char mostFrequentSample = mostFrequentLetter(sampleText);
        char mostFrequentCipher = mostFrequentLetter(ciphertext);
        int key = (mostFrequentCipher - mostFrequentSample + 26) % 26;
        return key;
    }
}
