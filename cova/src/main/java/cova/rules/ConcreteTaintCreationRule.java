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
package cova.rules;

import cova.core.InterproceduralCFG;
import cova.core.RuleManager;
import cova.data.Abstraction;
import cova.data.IConstraint;
import cova.data.WrappedAccessPath;
import cova.data.taints.AbstractTaint;
import cova.data.taints.ConcreteTaint;
import cova.data.taints.SourceTaint;
import cova.data.taints.SymbolicTaint;
import cova.vasco.Context;
import java.util.Set;
import soot.Local;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NumericConstant;
import soot.jimple.ReturnStmt;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;

/**
 * The Class ConcreteTaintCreationRule defines the creation rules of concrete taints.
 *
 * <p>Concrete taints can be created at an assignment, return stmt and callee with parameters.
 */
public class ConcreteTaintCreationRule {
  private final boolean concreteTaintAtAssignStmtOn;
  private final boolean concreteTaintAtReturnStmtOn;
  private final boolean concreteTaintAtCalleeOn;
  private final InterproceduralCFG icfg;

  public ConcreteTaintCreationRule(
      boolean taintAtAssignStmtOn,
      boolean taintAtReturnStmtOn,
      boolean taintAtCalleeOn,
      RuleManager ruleManager) {
    concreteTaintAtAssignStmtOn = taintAtAssignStmtOn;
    concreteTaintAtReturnStmtOn = taintAtReturnStmtOn;
    concreteTaintAtCalleeOn = taintAtCalleeOn;
    icfg = ruleManager.getIcfg();
  }

  public boolean normalFlowFunction(
      Context<SootMethod, Unit, Abstraction> context, Unit node, Unit succ, Abstraction in) {
    boolean createdConcreteTaint = false;
    IConstraint constraint = in.getConstraintOfStmt();
    if (concreteTaintAtAssignStmtOn && node instanceof AssignStmt) {
      AssignStmt assignStmt = (AssignStmt) node;
      Value leftOp = assignStmt.getLeftOp();
      Value rightOp = assignStmt.getRightOp();
      // create concrete taint at assign statement, when the right operand is a constant.
      if (rightOp instanceof Constant) {
        if (WrappedAccessPath.isSupportedType(leftOp)) {
          ConcreteTaint t = new ConcreteTaint(new WrappedAccessPath(leftOp), constraint, rightOp);
          in.taints().add(t);
          createdConcreteTaint = true;
        }
      }
    }
    if (concreteTaintAtReturnStmtOn && node instanceof ReturnStmt) {
      ReturnStmt returnStmt = (ReturnStmt) node;
      Value returnValue = returnStmt.getOp();
      // create concrete taint at return statement, when the return value is a constant.
      if (returnValue instanceof Constant) {
        ConcreteTaint returnTaint =
            new ConcreteTaint(WrappedAccessPath.getRetAccessPath(null), constraint, returnValue);
        in.taints().add(returnTaint);
        createdConcreteTaint = true;
      }
    }
    return createdConcreteTaint;
  }

  public boolean callEntryFlowFunction(
      Context<SootMethod, Unit, Abstraction> context,
      SootMethod callee,
      Unit node,
      Unit succ,
      Abstraction in) {
    boolean createdConcreteTaint = false;
    if (concreteTaintAtCalleeOn) {
      IConstraint constraint = in.getConstraintOfStmt();
      // map each argument to corresponding parameter
      InvokeExpr invokeExpr = ((Stmt) node).getInvokeExpr();
      for (int i = 0; i < invokeExpr.getArgCount(); i++) {
        Value arg = invokeExpr.getArg(i);
        Local param = callee.getActiveBody().getParameterLocal(i);
        // if argument is numeric or string constant, create at callee site concrete taint
        if (arg instanceof NumericConstant || arg instanceof StringConstant) {
          WrappedAccessPath calleeSite = new WrappedAccessPath(param);
          Set<AbstractTaint> involved = in.taints().getTaintsWithAccessPath(calleeSite);
          // Do not create concrete taint if taint is only concrete in dummyMainClass
          boolean hasSourceTaint = false;
          for (AbstractTaint aTaint : involved) {
            if (aTaint instanceof SourceTaint) {
              hasSourceTaint = true;
            }
          }
          if (!hasSourceTaint) {
            ConcreteTaint taint = new ConcreteTaint(calleeSite, constraint, arg);
            in.taints().add(taint);
            createdConcreteTaint = true;
          }
        }
      }
    }
    return createdConcreteTaint;
  }

  public boolean callLocalFlowFunction(
      Context<SootMethod, Unit, Abstraction> context, Unit node, Unit succ, Abstraction in) {
    boolean createdConcreteTaint = false;
    Unit switchStmt = icfg.getPredAsLookupSwitchStmt(node);
    if (switchStmt != null) {
      // create concrete taint for lookup switch stmt
      if (node instanceof AssignStmt) {
        AssignStmt assignStmt = (AssignStmt) node;
        Value leftOp = assignStmt.getLeftOp();
        Value rightOp = assignStmt.getRightOp();
        if (rightOp instanceof InstanceInvokeExpr) {
          InstanceInvokeExpr expr = (InstanceInvokeExpr) rightOp;
          if (expr.getMethod().getName().equals("equals")) {
            Value base = expr.getBase();
            Set<AbstractTaint> involved =
                in.taints().getTaintsWithAccessPath(new WrappedAccessPath(base));
            Value value = expr.getArg(0);
            if (value instanceof Constant) {
              for (AbstractTaint taint : involved) {
                if (taint instanceof SymbolicTaint) {
                  // create concrete taint at equals function.
                  ConcreteTaint t =
                      new ConcreteTaint(
                          new WrappedAccessPath(leftOp),
                          in.getConstraintOfStmt(),
                          value,
                          (SymbolicTaint) taint,
                          switchStmt);
                  in.taints().add(t);
                  createdConcreteTaint = true;
                }
              }
            }
          }
        }
      }
    }
    return createdConcreteTaint;
  }
}
