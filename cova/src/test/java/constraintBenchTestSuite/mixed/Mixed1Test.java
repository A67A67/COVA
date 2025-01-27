/**
 * Copyright (C) 2019 Linghui Luo
 *
 * <p>This library is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * <p>This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * <p>You should have received a copy of the GNU Lesser General Public License along with this
 * program. If not, see <http://www.gnu.org/licenses/>.
 */
package constraintBenchTestSuite.mixed;

import com.microsoft.z3.BoolExpr;
import cova.core.SMTSolverZ3;
import cova.data.ConstraintZ3;
import cova.data.Operator;
import org.junit.Assert;
import org.junit.Test;
import soot.IntType;
import utils.ConstraintBenchTestFramework;

/** */
public class Mixed1Test extends ConstraintBenchTestFramework {

  public Mixed1Test() {
    targetTestClassName = "constraintBench.test.mixed.Mixed1";
  }

  @Test
  public void test() {
    BoolExpr termOnClick = SMTSolverZ3.getInstance().makeBoolTerm(onClick + "_0", false);
    BoolExpr termnOnScroll = SMTSolverZ3.getInstance().makeBoolTerm(onScroll + "_0", false);
    BoolExpr termD =
        SMTSolverZ3.getInstance()
            .makeNonTerminalExpr(D, false, "5", true, IntType.v(), Operator.LE);
    BoolExpr negatedD = SMTSolverZ3.getInstance().negate(termD, false);
    BoolExpr termA = SMTSolverZ3.getInstance().makeBoolTerm(A, false);
    BoolExpr negatedA = SMTSolverZ3.getInstance().negate(termA, false);
    BoolExpr termB = SMTSolverZ3.getInstance().makeBoolTerm(B, false);
    BoolExpr onClickAndScroll =
        SMTSolverZ3.getInstance().solve(termOnClick, termnOnScroll, Operator.AND, false);

    BoolExpr actual = ((ConstraintZ3) results.get(16)).getExpr();
    boolean equivalent = SMTSolverZ3.getInstance().prove(termOnClick, actual);
    Assert.assertTrue(equivalent);

    BoolExpr expected = SMTSolverZ3.getInstance().solve(termOnClick, negatedD, Operator.AND, false);
    actual = ((ConstraintZ3) results.get(18)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected, actual);
    Assert.assertTrue(equivalent);

    expected = SMTSolverZ3.getInstance().solve(termOnClick, termD, Operator.AND, false);
    actual = ((ConstraintZ3) results.get(20)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected, actual);
    Assert.assertTrue(equivalent);

    actual = ((ConstraintZ3) results.get(22)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(termOnClick, actual);
    Assert.assertTrue(equivalent);

    BoolExpr temp0 = SMTSolverZ3.getInstance().solve(onClickAndScroll, termA, Operator.AND, false);
    actual = ((ConstraintZ3) results.get(27)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(temp0, actual);
    Assert.assertTrue(equivalent);

    expected = SMTSolverZ3.getInstance().solve(temp0, termB, Operator.AND, false);
    actual = ((ConstraintZ3) results.get(28)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected, actual);
    Assert.assertTrue(equivalent);

    actual = ((ConstraintZ3) results.get(35)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(termA, actual);
    Assert.assertTrue(equivalent);

    actual = ((ConstraintZ3) results.get(37)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(negatedA, actual);
    Assert.assertTrue(equivalent);

    actual = ((ConstraintZ3) results.get(45)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(termOnClick, actual);
    Assert.assertTrue(equivalent);

    expected = SMTSolverZ3.getInstance().solve(termOnClick, termA, Operator.AND, false);
    actual = ((ConstraintZ3) results.get(46)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected, actual);
    Assert.assertTrue(equivalent);

    BoolExpr temp1 = SMTSolverZ3.getInstance().solve(onClickAndScroll, termA, Operator.AND, false);
    BoolExpr temp2 = SMTSolverZ3.getInstance().solve(termOnClick, negatedA, Operator.AND, false);
    expected = SMTSolverZ3.getInstance().solve(temp1, temp2, Operator.OR, false);
    actual = ((ConstraintZ3) results.get(48)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected, actual);
    Assert.assertTrue(equivalent);
  }
}
