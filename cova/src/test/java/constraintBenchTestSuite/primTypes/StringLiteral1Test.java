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
package constraintBenchTestSuite.primTypes;

import com.microsoft.z3.BoolExpr;
import cova.core.SMTSolverZ3;
import cova.data.ConstraintZ3;
import cova.rules.StringMethod;
import org.junit.Assert;
import org.junit.Test;
import utils.ConstraintBenchTestFramework;

/** */
public class StringLiteral1Test extends ConstraintBenchTestFramework {

  public StringLiteral1Test() {
    targetTestClassName = "constraintBench.test.primTypes.StringLiteral1";
  }

  @Test
  public void test() {
    BoolExpr termX =
        SMTSolverZ3.getInstance().makeStrTermWithOneVariable(FA, "a", StringMethod.CONTAINS);
    BoolExpr actual = ((ConstraintZ3) results.get(16)).getExpr();
    boolean equivalent = SMTSolverZ3.getInstance().prove(termX, actual);
    Assert.assertTrue(equivalent);
  }
}
