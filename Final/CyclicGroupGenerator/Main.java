import java.util.List;

public class Main {
  public static void main(String[] args) {
    //p = list of prime numbers you want to find generators for
    List<Integer> p = List.of(13,29,37);
    
    FindGenerators findGenerators = new FindGenerators();
    findGenerators.printResults(p);
  }
}