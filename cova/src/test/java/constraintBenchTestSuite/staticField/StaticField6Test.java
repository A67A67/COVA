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
package constraintBenchTestSuite.staticField;

import org.junit.Assert;
import org.junit.Ignore;
import utils.ConstraintBenchTestFramework;

/** */
public class StaticField6Test extends ConstraintBenchTestFramework {

  public StaticField6Test() {
    targetTestClassName = "constraintBench.test.staticField.StaticField6";
  }

  @Ignore
  public void test() {
    Assert.assertTrue(results.containsKey(21));
  }
}