public class Main {
    public static void main(String[] args) {
        int[][] polynomials = {{1, 0, 1}, {1, 0, 1, 1}, {1, 0, 1}, {1, 1}};
        GF2mCalculator calculator = new GF2mCalculator();
        calculator.processExamples(polynomials);
    }
}

