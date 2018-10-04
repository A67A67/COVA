package constraintBenchTestSuite;

import com.microsoft.z3.BoolExpr;

import org.junit.Assert;
import org.junit.Test;

import core.SMTSolverZ3;
import data.ConstraintZ3;
import utils.ConstraintBenchTestFramework;

/**
 * 
 * 
 */
public class BooleanSingle3Test extends ConstraintBenchTestFramework {

  public BooleanSingle3Test() {
    targetTestClassName = "constraintBench.test.primTypes.BooleanSingle3";
  }

  @Test
  public void test() {
    BoolExpr expected1 = SMTSolverZ3.getInstance().makeBoolTerm(A, false);// A
    BoolExpr expected2 = SMTSolverZ3.getInstance().makeBoolTerm(A, true);// !A

    BoolExpr actual1 = ((ConstraintZ3) results.get(13)).getExpr();
    boolean equivalent = SMTSolverZ3.getInstance().prove(expected1, actual1);
    Assert.assertTrue(equivalent);

    BoolExpr actual2 = ((ConstraintZ3) results.get(15)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected2, actual2);
    Assert.assertTrue(equivalent);
  }
}
