package constraintBench.test.primTypes;

import constraintBench.utils.Configuration;

/**
 * 
 * @author Linghui Luo
 */
public class StringLiteral1 {

  public void test() {
    String s1 = Configuration.fieldA;
    String s2 = s1;
    s1 = "abc";
    if (s2.contains("a")) {
      System.out.println();// str.contains(FA, "a")
    }
  }

}
