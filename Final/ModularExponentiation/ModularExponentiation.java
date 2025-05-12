public class ModularExponentiation {

    public void printResults(int base, int exp, int mod){
        System.out.println(base+"^"+ exp +" mod"+ mod + " = " + modExp(base, exp, mod));
    }

    public int modExp(int base, int exponent, int mod) {
        int result = 1;
        base = base % mod;

        while (exponent>0) {
            if (exponent % 2 == 1) {
            result = (result*base) % mod;
            }
            exponent = exponent >> 1;
            base = (base*base) % mod;
        }
        return result;
    }
}
