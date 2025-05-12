import java.util.*;

class FindGenerators {

  public void printResults(List<Integer> p){
    for(int i=0; i<p.size(); i++){
      System.out.println("Generators of Z" + "*" + p.get(i) +" are: " + findGenerators(p.get(i)));
    }
  }

  public List<Integer> findGenerators(int p) {
    List<Integer> generators = new ArrayList<>();
    for (int g=2; g<p; g++) {
      Set<Integer> powers = new HashSet<>();
      for (int k=1; k<p; k++) {
        powers.add(modExp(g, k, p));
      }
      if (powers.size() == p - 1) {
        generators.add(g);
      }
    }
    return generators;
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