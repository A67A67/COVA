package constraintBench.test.imprecise;

import constraintBench.utils.Configuration;

/**
 * @author Linghui Luo
 * 
 */
public class ImpreciseMultiple4 {

  public void test() {
    int d = Configuration.featureD();
    if (d > 8) {
      int a = Configuration.fieldA.length();// D > 8
      int b = Configuration.fieldB.length();// D > 8
      int c = a + b;// D > 8
      if (c > 0) {// D > 8
        System.out.println(); // D>8 ^ (str.len(a) + str.len(b) > 0)
      }
    }
  }
}
