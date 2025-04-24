class GF2mCalculator {
    public void processExamples(int[][] polynomials) {
        //Example 1: A(x) = x^2 + 1, B(x) = x^3 + x^2 + 1
        System.out.println("Example 1: A(x) = x^2 + 1, B(x) = x^3 + x^2 + 1");
        performOperations(polynomials[0], polynomials[1], 4);
        
        //Example 2: A(x) = x^2 + 1, B(x) = x + 1
        System.out.println("\nExample 2: A(x) = x^2 + 1, B(x) = x + 1");
        performOperations(polynomials[2], polynomials[3], 4);
    }
    
    private void performOperations(int[] A, int[] B, int m) {
        int[] P = {1, 1, 0, 0, 1};
        
        System.out.println("A(x) = " + polynomialToString(A));
        System.out.println("B(x) = " + polynomialToString(B));
        
        int[] sum = addPolynomials(A, B);
        System.out.println("A(x) + B(x) = " + polynomialToString(sum));
        
        int[] product = multiplyPolynomials(A, B);
        int[] result = modReduce(product, P);
        System.out.println("A(x) * B(x) mod P(x) = " + polynomialToString(result));
    }
    
    private int[] addPolynomials(int[] A, int[] B) {
        int maxLength = Math.max(A.length, B.length);
        int[] result = new int[maxLength];
        
        for (int i = 0; i < maxLength; i++) {
            int aCoeff = (i < A.length) ? A[i] : 0;
            int bCoeff = (i < B.length) ? B[i] : 0;
            result[i] = aCoeff ^ bCoeff;
        }
        
        return result;
    }
    
    private int[] multiplyPolynomials(int[] A, int[] B) {
        int[] result = new int[A.length + B.length - 1];
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {  
                for (int j = 0; j < B.length; j++) {
                    if (B[j] != 0) { 
                        //In GF(2), 1*1 = 1, so we just XOR the results
                        result[i + j] ^= A[i] * B[j];
                    }
                }
            }
        }
        
        return result;
    }
    
    private int[] modReduce(int[] polynomial, int[] modulus) {
        int[] result = polynomial.clone();
        int modDegree = modulus.length - 1;
        
        int resultDegree = result.length - 1;
        while (resultDegree >= 0 && result[resultDegree] == 0) {
            resultDegree--;
        }
        
        //Perform the modular reduction
        while (resultDegree >= modDegree) {
            if (result[resultDegree] == 1) {
                int shift = resultDegree - modDegree;
                for (int i = 0; i <= modDegree; i++) {
                    if (modulus[i] == 1) {
                        result[i + shift] ^= 1;
                    }
                }
            }
            
            resultDegree = result.length - 1;
            while (resultDegree >= 0 && result[resultDegree] == 0) {
                resultDegree--;
            }
        }
        
        int newLength = resultDegree + 1;
        int[] trimmed = new int[Math.max(newLength, 1)];
        for (int i = 0; i < trimmed.length && i < result.length; i++) {
            trimmed[i] = result[i];
        }
        
        return trimmed;
    }
    
    private String polynomialToString(int[] poly) {
        if (poly.length == 0 || (poly.length == 1 && poly[0] == 0)) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = poly.length - 1; i >= 0; i--) {
            if (poly[i] == 1) {
                if (!first) {
                    sb.append(" + ");
                }
                first = false;
                
                if (i == 0) {
                    sb.append("1");
                } else if (i == 1) {
                    sb.append("x");
                } else {
                    sb.append("x^").append(i);
                }
            }
        }
        return sb.toString();
    }
}