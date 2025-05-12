public class EEA {

    public static int[] calculate(int r0, int r1) {
        if (r0 <= 0 || r1 <= 0) {
            throw new IllegalArgumentException("Both numbers must be positive integers.");
        }
        
        //Swap if r0 < r1
        boolean swapped = false;
        if (r0 < r1) {
            int temp = r0;
            r0 = r1;
            r1 = temp;
            swapped = true;
        }
        
        //Initialize values as per the algorithm
        int s0 = 1, s1 = 0;
        int t0 = 0, t1 = 1;
        int i = 1;
        
        System.out.println("\nAlgorithm steps:");
        System.out.println("i\tri\tqi\tsi\tti");
        System.out.println("0\t" + r0 + "\t-\t" + s0 + "\t" + t0);
        System.out.println("1\t" + r1 + "\t-\t" + s1 + "\t" + t1);
        
        //Store original values to display at the end
        int origR0 = r0;
        int origR1 = r1;
        
        //Execute the algorithm while r_i is not 0
        while (r1 != 0) {
            i++;
            
            //Calculate quotient
            int q = r0 / r1;
            
            //Calculate remainder
            int r = r0 % r1;
            
            //Calculate s_i and t_i
            int s = s0 - q * s1;
            int t = t0 - q * t1;
            
            //Print current step
            System.out.println(i + "\t" + r + "\t" + q + "\t" + s + "\t" + t);
            
            //Update values for next iteration
            r0 = r1;
            r1 = r;
            s0 = s1;
            s1 = s;
            t0 = t1;
            t1 = t;
        }
        
        //If we swapped the inputs, swap the coefficients in the result
        if (swapped) {
            int temp = s0;
            s0 = t0;
            t0 = temp;
        }
        
        //Print just the GCD result
        System.out.println("\nResult:");
        System.out.println("GCD = " + r0);
        
        //Return the GCD and the coefficients s and t
        return new int[] {r0, s0, t0};
    }
}