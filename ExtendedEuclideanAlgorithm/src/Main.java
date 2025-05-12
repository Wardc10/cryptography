public class Main {
    public static void main(String[] args) {
        int r0 = 1408;
        int r1 = 271;
        
        System.out.println("Extended Euclidean Algorithm");
        System.out.println("Input values: r0 = " + r0 + ", r1 = " + r1);
        
        try {
            int[] result = EEA.calculate(r0, r1);
            
            int gcd = result[0];
            System.out.println("Final result: GCD = " + gcd);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}