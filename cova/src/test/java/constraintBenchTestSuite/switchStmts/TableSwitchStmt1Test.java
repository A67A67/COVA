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
package constraintBenchTestSuite.switchStmts;

import com.microsoft.z3.BoolExpr;
import cova.core.SMTSolverZ3;
import cova.data.ConstraintZ3;
import cova.data.Operator;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import soot.IntType;
import utils.ConstraintBenchTestFramework;

/** */
public class TableSwitchStmt1Test extends ConstraintBenchTestFramework {

  public TableSwitchStmt1Test() {
    targetTestClassName = "constraintBench.test.switchStmts.TableSwitchStmt1";
  }

  @Test
  public void test() {
    // D = 2
    BoolExpr expected1 =
        SMTSolverZ3.getInstance()
            .makeNonTerminalExpr(D, false, "2", true, IntType.v(), Operator.EQ);
    BoolExpr negate1 = SMTSolverZ3.getInstance().negate(expected1, false);
    BoolExpr actual = ((ConstraintZ3) results.get(15)).getExpr();
    boolean equivalent = SMTSolverZ3.getInstance().prove(expected1, actual);
    Assert.assertTrue(equivalent);
    // D = 4
    BoolExpr expected2 =
        SMTSolverZ3.getInstance()
            .makeNonTerminalExpr(D, false, "4", true, IntType.v(), Operator.EQ);
    BoolExpr negate2 = SMTSolverZ3.getInstance().negate(expected2, false);
    actual = ((ConstraintZ3) results.get(18)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected2, actual);
    Assert.assertTrue(equivalent);
    // D = 8
    BoolExpr expected3 =
        SMTSolverZ3.getInstance()
            .makeNonTerminalExpr(D, false, "8", true, IntType.v(), Operator.EQ);
    BoolExpr negate3 = SMTSolverZ3.getInstance().negate(expected3, false);
    actual = ((ConstraintZ3) results.get(21)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected3, actual);
    Assert.assertTrue(equivalent);
    // !(D = 2)^!(D = 4)^!(D = 8)
    List<BoolExpr> exprs = new ArrayList<>();
    exprs.add(negate1);
    exprs.add(negate2);
    exprs.add(negate3);
    BoolExpr expected4 = SMTSolverZ3.getInstance().makeConjunction(exprs, false);
    actual = ((ConstraintZ3) results.get(24)).getExpr();
    equivalent = SMTSolverZ3.getInstance().prove(expected4, actual);
    Assert.assertTrue(equivalent);
    Assert.assertFalse(results.containsKey(27));
  }
}
