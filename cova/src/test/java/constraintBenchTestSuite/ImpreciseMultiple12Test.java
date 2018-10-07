package constraintBenchTestSuite;

import de.upb.swt.cova.core.SMTSolverZ3;
import de.upb.swt.cova.data.ConstraintZ3;

import com.microsoft.z3.BoolExpr;

import org.junit.Assert;
import org.junit.Test;

import utils.ConstraintBenchTestFramework;

/**
 * 
 *
 */
public class ImpreciseMultiple12Test extends ConstraintBenchTestFramework {

  public ImpreciseMultiple12Test() {
    targetTestClassName = "constraintBench.test.imprecise.ImpreciseMultiple12";
  }

  @Test
  public void test() {
    StringBuilder sb = new StringBuilder("im(");
    sb.append(P);
    sb.append("+");
    sb.append(Q);
    sb.append(")_0");
    String imPQ = sb.toString();
    // !im(P+Q)_0
    BoolExpr expected1 = SMTSolverZ3.getInstance().makeBoolTerm(imPQ, true);
    BoolExpr actual = ((ConstraintZ3) results.get(17)).getExpr();
    boolean equivalent = SMTSolverZ3.getInstance().prove(expected1, actual);
    Assert.assertTrue(equivalent);
    // A
    BoolExpr expected2 = SMTSolverZ3.getInstance().makeBoolTerm(A, false);
    actual = ((ConstraintZ3) results.get(20)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected2, actual);
    Assert.assertTrue(equivalent);
  }
}
