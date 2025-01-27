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
package unitTestSuite.testData;

import static org.junit.Assert.assertEquals;

import com.microsoft.z3.BoolExpr;
import cova.core.SMTSolverZ3;
import cova.data.ConstraintZ3;
import cova.data.WitnessPath;
import cova.data.WrappedAccessPath;
import cova.data.WrappedTaintSet;
import cova.data.taints.ConcreteTaint;
import cova.data.taints.ImpreciseTaint;
import cova.data.taints.SourceTaint;
import cova.data.taints.SymbolicTaint;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import soot.IntType;
import soot.Local;
import soot.jimple.IntConstant;
import soot.jimple.Jimple;
import utils.UnitTestFramework;

public class testWrappedTaintSet extends UnitTestFramework {
  private final BoolExpr e1 = SMTSolverZ3.getInstance().makeBoolTerm("A", false);
  private final BoolExpr e2 = SMTSolverZ3.getInstance().makeBoolTerm("A", true);
  private final Local local = Jimple.v().newLocal("t", IntType.v());
  private final String symbol = "SymA";
  private final WrappedAccessPath accessPath = new WrappedAccessPath(local);
  private final ConstraintZ3 c1 = new ConstraintZ3(e1, "A", new WitnessPath());
  private final ConstraintZ3 c2 = new ConstraintZ3(e2, "A", new WitnessPath());
  private final SourceTaint taint1 = new SourceTaint(accessPath, c1, symbol);
  private final SourceTaint taint2 = new SourceTaint(new WrappedAccessPath(local), c2, symbol);

  @Test
  public void testMeetSourceTaints() {
    WrappedTaintSet set1 = new WrappedTaintSet();
    WrappedTaintSet set2 = new WrappedTaintSet();
    set1.add(taint1);
    set2.add(taint2);
    WrappedTaintSet actualSet = set1.meet(set2);
    SourceTaint expectedTaint = new SourceTaint(accessPath, ConstraintZ3.getTrue(), symbol);
    WrappedTaintSet expectedSet = new WrappedTaintSet();
    expectedSet.add(expectedTaint);
    assertEquals(expectedSet, actualSet);
  }

  @Test
  public void testMeetImpreciseTaints() {
    WrappedTaintSet set1 = new WrappedTaintSet();
    WrappedTaintSet set2 = new WrappedTaintSet();
    Local local = Jimple.v().newLocal("i", IntType.v());
    SymbolicTaint[] parentTaints = new SymbolicTaint[] {taint1};
    List<String> sourceSymbolics = new ArrayList<String>();
    sourceSymbolics.add(taint1.getSymbolicName());
    ImpreciseTaint taint3 =
        new ImpreciseTaint(
            new WrappedAccessPath(local), c1, parentTaints, sourceSymbolics, "im(A)");
    ImpreciseTaint taint4 =
        new ImpreciseTaint(
            new WrappedAccessPath(local), c2, parentTaints, sourceSymbolics, "im(A)");
    set1.add(taint3);
    set2.add(taint4);
    WrappedTaintSet actualSet = set1.meet(set2);
    ImpreciseTaint expectedTaint =
        new ImpreciseTaint(
            new WrappedAccessPath(local),
            ConstraintZ3.getTrue(),
            parentTaints,
            sourceSymbolics,
            "im(A)");
    WrappedTaintSet expectedSet = new WrappedTaintSet();
    expectedSet.add(expectedTaint);
    assertEquals(expectedSet, actualSet);
  }

  @Test
  public void testMeetConcreteTaints() {
    WrappedTaintSet set1 = new WrappedTaintSet();
    WrappedTaintSet set2 = new WrappedTaintSet();
    Local local = Jimple.v().newLocal("c", IntType.v());
    IntConstant value = IntConstant.v(10);
    ConcreteTaint taint3 = new ConcreteTaint(new WrappedAccessPath(local), c1, value);
    ConcreteTaint taint4 = new ConcreteTaint(new WrappedAccessPath(local), c2, value);
    set1.add(taint3);
    set2.add(taint4);
    WrappedTaintSet actualSet = set1.meet(set2);
    ConcreteTaint expectedTaint =
        new ConcreteTaint(new WrappedAccessPath(local), ConstraintZ3.getTrue(), value);
    WrappedTaintSet expectedSet = new WrappedTaintSet();
    expectedSet.add(expectedTaint);
    assertEquals(expectedSet, actualSet);
  }
}
