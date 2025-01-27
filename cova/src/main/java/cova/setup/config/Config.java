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
package cova.setup.config;

import cova.rules.ConcreteTaintCreationRule;
import java.io.File;

// TODO: Auto-generated Javadoc
/** The Class Configuration. */
public class Config {

  /** True, if the UI constraint creation rule is on. */
  private boolean uIConstraintCreationRuleOn;

  /** True, if the taint constraint creation rule is on. */
  private boolean taintConstraintCreationRuleOn;

  /** True, if the source taint creation rule is on. */
  private boolean sourceTaintCreationRule;

  /** True, if the taint propagation rule is on. */
  private boolean taintPropagationRuleOn;

  /** True, if the imprecise taint creation rule is on. */
  private boolean impreciseTaintCreationRuleOn;

  /** The imprecise propagation rule on. */
  private boolean imprecisePropagationRuleOn;

  /** True, if the concrete taint propagation rule is on. */
  private boolean concreteTaintCreationRuleOn;

  /** True, if the string taint propagation rule is on. */
  private boolean stringTaintCreationRuleOn;

  /** The concrete taint at assignStmt on. */
  private boolean concreteTaintAtAssignStmtOn;

  /** The concrete taint at returnStmt on. */
  private boolean concreteTaintAtReturnStmtOn;

  /** The concrete taint at callee on. */
  private boolean concreteTaintAtCalleeOn;

  /** True, if propagate taints which are static fields. */
  private boolean staticFieldPropagationOn;

  /** True, if allows time out. */
  private boolean timeOutOn;

  /** The time out duration. */
  private int timeOutDuration;

  /** True, if print jimple output. */
  private boolean writeJimpleOutput;

  /** True, if print html output. */
  private boolean writeHtmlOutput;

  /** True, if the whole constraint map should be computed. */
  private boolean computeConstraintMap;

  /** The location for configuration files. */
  private String configDir;

  /** True, if the control flow path should be recorded during the analysis. */
  private boolean recordPath;

  /** Instantiates a new configuration with nothing enabled. */
  public Config() {
    uIConstraintCreationRuleOn = false;
    taintConstraintCreationRuleOn = false;
    sourceTaintCreationRule = false;
    taintPropagationRuleOn = false;
    impreciseTaintCreationRuleOn = false;
    concreteTaintCreationRuleOn = false;
    stringTaintCreationRuleOn = false;
    concreteTaintAtAssignStmtOn = false;
    concreteTaintAtReturnStmtOn = false;
    concreteTaintAtCalleeOn = false;
    staticFieldPropagationOn = false;
    timeOutOn = false;
    timeOutDuration = 0;
    writeJimpleOutput = false;
    writeHtmlOutput = false;
    computeConstraintMap = false;
    recordPath = false;
    configDir = System.getProperty("user.dir") + File.separator + "config";
  }

  /**
   * Instantiates a new config.
   *
   * @param uIConstraintCreationRuleOn
   * @param taintConstraintCreationRuleOn
   * @param sourceTaintCreationRule
   * @param taintPropagationRuleOn
   * @param impreciseTaintCreationRule
   * @param concreteTaintPropagationRuleOn
   * @param staticFieldPropagation
   * @param timeOutOn
   * @param timeOutDuration
   * @param writeJimpleOutput
   * @param writeHtmlOutput
   * @param computeConstraintMap
   * @param recordPath the record path
   */
  public Config(
      boolean uIConstraintCreationRuleOn,
      boolean taintConstraintCreationRuleOn,
      boolean sourceTaintCreationRule,
      boolean taintPropagationRuleOn,
      boolean impreciseTaintCreationRule,
      boolean concreteTaintPropagationRuleOn,
      boolean staticFieldPropagation,
      boolean timeOutOn,
      int timeOutDuration,
      boolean writeJimpleOutput,
      boolean writeHtmlOutput,
      boolean computeConstraintMap,
      boolean recordPath) {
    this();
    this.uIConstraintCreationRuleOn = uIConstraintCreationRuleOn;
    this.taintConstraintCreationRuleOn = taintConstraintCreationRuleOn;
    this.sourceTaintCreationRule = sourceTaintCreationRule;
    this.taintPropagationRuleOn = taintPropagationRuleOn;
    impreciseTaintCreationRuleOn = impreciseTaintCreationRule;
    concreteTaintCreationRuleOn = concreteTaintPropagationRuleOn;
    staticFieldPropagationOn = staticFieldPropagation;
    this.timeOutOn = timeOutOn;
    this.timeOutDuration = timeOutDuration;
    this.writeJimpleOutput = writeJimpleOutput;
    this.writeHtmlOutput = writeHtmlOutput;
    this.computeConstraintMap = computeConstraintMap;
    this.recordPath = recordPath;
  }

  /**
   * Checks if the control flow path should be recorded during the analysis.
   *
   * @return true, if successful
   */
  public boolean recordPath() {
    return recordPath;
  }

  /**
   * Sets the recordPath configuration option.
   *
   * @param recordPath the new record path
   */
  public void setRecordPath(boolean recordPath) {
    this.recordPath = recordPath;
  }

  /**
   * Checks if is UI constraint creation rule on.
   *
   * @return true, if is UI constraint creation rule on
   */
  public boolean isUIConstraintCreationRuleOn() {
    return uIConstraintCreationRuleOn;
  }

  /**
   * Sets the UI constraint creation rule on.
   *
   * @param uIConstraintCreationRuleOn the new u I constraint creation rule on
   */
  public void setUIConstraintCreationRuleOn(boolean uIConstraintCreationRuleOn) {
    this.uIConstraintCreationRuleOn = uIConstraintCreationRuleOn;
  }

  /**
   * Checks if is taint constraint creation rule on.
   *
   * @return true, if is taint constraint creation rule on
   */
  public boolean isTaintConstraintCreationRuleOn() {
    return taintConstraintCreationRuleOn;
  }

  /**
   * Sets the taint constraint creation rule on.
   *
   * @param taintConstraintCreationRuleOn the new taint constraint creation rule on
   */
  public void setTaintConstraintCreationRuleOn(boolean taintConstraintCreationRuleOn) {
    this.taintConstraintCreationRuleOn = taintConstraintCreationRuleOn;
  }

  /**
   * Checks if is source taint creation rule on.
   *
   * @return true, if is source taint creation rule on
   */
  public boolean isSourceTaintCreationRuleOn() {
    return sourceTaintCreationRule;
  }

  /**
   * Sets the source taint creation rule on.
   *
   * @param sourceTaintCreationRule the new source taint creation rule on
   */
  public void setSourceTaintCreationRuleOn(boolean sourceTaintCreationRule) {
    this.sourceTaintCreationRule = sourceTaintCreationRule;
  }

  /**
   * Checks if is taint propagation rule on.
   *
   * @return true, if is taint propagation rule on
   */
  public boolean isTaintPropagationRuleOn() {
    return taintPropagationRuleOn;
  }

  /**
   * Sets the taint propagation rule on.
   *
   * @param taintPropagationRuleOn the new taint propagation rule on
   */
  public void setTaintPropagationRuleOn(boolean taintPropagationRuleOn) {
    this.taintPropagationRuleOn = taintPropagationRuleOn;
  }

  /**
   * Checks if is imprecise taint propagation rule on.
   *
   * @return true, if is imprecise taint propagation rule on
   */
  public boolean isImpreciseTaintCreationRuleOn() {
    return impreciseTaintCreationRuleOn;
  }

  /**
   * Sets the imprecise taint propagation rule on.
   *
   * @param impreciseTaintCreationRuleOn the new imprecise taint propagation rule on
   */
  public void setImpreciseTaintCreationRuleOn(boolean impreciseTaintCreationRuleOn) {
    this.impreciseTaintCreationRuleOn = impreciseTaintCreationRuleOn;
  }

  /**
   * Checks if is imprecise propagation rule on.
   *
   * @return true, if is imprecise propagation rule on
   */
  public boolean isImprecisePropagationRuleOn() {
    return imprecisePropagationRuleOn;
  }

  /**
   * Sets the imprecise propagation rule on.
   *
   * @param imprecisePropagationRuleOn the new imprecise propagation rule on
   */
  public void setImprecisePropagationRuleOn(boolean imprecisePropagationRuleOn) {
    this.imprecisePropagationRuleOn = imprecisePropagationRuleOn;
  }

  /**
   * Checks if is concrete taint creation rule on.
   *
   * @return true, if is concrete taint creation rule on
   */
  public boolean isConcreteTaintCreationRuleOn() {
    return concreteTaintCreationRuleOn;
  }

  /**
   * Sets the concrete taint creation rule on.
   *
   * @param concreteTaintCreationRuleOn the new concrete taint creation rule on
   * @param assignOn the concrete taint at assign stmt rule on
   * @param returnOn the concrete taint at return stmt rule on
   * @param calleeOn the concrete taint at callee rule on
   */
  public void setConcreteTaintCreationRuleOn(
      boolean concreteTaintCreationRuleOn, boolean assignOn, boolean returnOn, boolean calleeOn) {
    this.concreteTaintCreationRuleOn = concreteTaintCreationRuleOn;
    if (concreteTaintCreationRuleOn) {
      concreteTaintAtAssignStmtOn = assignOn;
      concreteTaintAtReturnStmtOn = returnOn;
      concreteTaintAtCalleeOn = calleeOn;
    } else {
      concreteTaintAtAssignStmtOn = false;
      concreteTaintAtReturnStmtOn = false;
      concreteTaintAtCalleeOn = false;
    }
  }

  /**
   * Sets the concrete taint creation rule on. The sub rules are all enabled if
   * concreteTaintCreationRuleOn is true, otherwise they are all disabled. {@link
   * ConcreteTaintCreationRule}.
   *
   * @param concreteTaintCreationRuleOn the new concrete taint creation rule on
   */
  public void setConcreteTaintCreationRuleOn(boolean concreteTaintCreationRuleOn) {
    this.concreteTaintCreationRuleOn = concreteTaintCreationRuleOn;
    if (!concreteTaintCreationRuleOn) {
      concreteTaintAtAssignStmtOn = false;
      concreteTaintAtReturnStmtOn = false;
      concreteTaintAtCalleeOn = false;
    }
  }

  public boolean isStringTaintCreationRuleOn() {
    return stringTaintCreationRuleOn;
  }

  public void setStringTaintCreationRuleOn(boolean stringTaintCreationRuleOn) {
    this.stringTaintCreationRuleOn = stringTaintCreationRuleOn;
  }

  /**
   * Checks if is concrete taint at assign stmt on.
   *
   * @return true, if is concrete taint at assign stmt on
   */
  public boolean isConcreteTaintAtAssignStmtOn() {
    return concreteTaintAtAssignStmtOn;
  }

  /**
   * Checks if is concrete taint at return stmt on.
   *
   * @return true, if is concrete taint at return stmt on
   */
  public boolean isConcreteTaintAtReturnStmtOn() {
    return concreteTaintAtReturnStmtOn;
  }

  /**
   * Checks if is concrete taint at callee on.
   *
   * @return true, if is concrete taint at callee on
   */
  public boolean isConcreteTaintAtCalleeOn() {
    return concreteTaintAtCalleeOn;
  }

  /**
   * Checks if is static field propagation rule is on.
   *
   * @return true, if is static field propagation
   */
  public boolean isStaticFieldPropagationRuleOn() {
    return staticFieldPropagationOn;
  }

  /**
   * Sets the static field propagation.
   *
   * @param staticFieldPropagation the new static field propagation
   */
  public void setStaticFieldPropagationRuleOn(boolean staticFieldPropagation) {
    staticFieldPropagationOn = staticFieldPropagation;
  }

  /**
   * Checks if is time out on.
   *
   * @return true, if is time out on
   */
  public boolean isTimeOutOn() {
    return timeOutOn;
  }

  /**
   * Sets the time out on.
   *
   * @param timeOutDuration the time out duration in seconds
   */
  public void setTimeOutOn(int timeOutDuration) {
    timeOutOn = true;
    this.timeOutDuration = timeOutDuration;
  }

  /**
   * Gets the time out duration.
   *
   * @return the time out duration
   */
  public int getTimeOutDuration() {
    return timeOutDuration;
  }

  /**
   * Checks if should write jimple output.
   *
   * @return true, if should write jimple output
   */
  public boolean isWriteJimpleOutput() {
    return writeJimpleOutput;
  }

  /**
   * Sets the writeJimpleOutput option.
   *
   * @param writeJimpleOutput the new write jimple output
   */
  public void setWriteJimpleOutput(boolean writeJimpleOutput) {
    this.writeJimpleOutput = writeJimpleOutput;
  }

  /**
   * Checks if should write html output.
   *
   * @return true, if should write html output
   */
  public boolean isWriteHtmlOutput() {
    return writeHtmlOutput;
  }

  /**
   * Check if the whole constraint map should be computed .
   *
   * @return true, if should compute
   */
  public boolean computeConstraintMap() {
    return computeConstraintMap;
  }

  /**
   * Sets the computeConstraintMap option.
   *
   * @param computeConstraintMap the new computeConstraintMap value
   */
  public void setComputeConstraintMap(boolean computeConstraintMap) {
    this.computeConstraintMap = computeConstraintMap;
  }
  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    String s = "\n";
    if (isUIConstraintCreationRuleOn()) {
      s += "CONFIG: UIConstraintCreationRule is enabled.\n";
    } else {
      s += "CONFIG: UIConstraintCreationRule is NOT enabled.\n";
    }
    if (isTaintConstraintCreationRuleOn()) {
      s += "CONFIG: TaintConstraintCreationRule is enabled.\n";
    } else {
      s += "CONFIG: TaintConstraintCreationRule is NOT enabled.\n";
    }
    if (isTaintPropagationRuleOn()) {
      s += "CONFIG: TaintPropagationRule is enabled.\n";
    } else {
      s += "CONFIG: TaintPropagationRule is NOT enabled.\n";
    }
    if (isSourceTaintCreationRuleOn()) {
      s += "CONFIG: SourceTaintCreationRule is enabled.\n";
    } else {
      s += "CONFIG: SourceTaintCreationRule is NOT enabled.\n";
    }
    if (isImpreciseTaintCreationRuleOn()) {
      s += "CONFIG: ImpreciseTaintCreationRule is enabled.\n";
    } else {
      s += "CONFIG: ImpreciseTaintCreationRule is NOT enabled.\n";
    }

    if (isImprecisePropagationRuleOn()) {
      s += "CONFIG: ImprecisePropagationRule is enabled.\n";
    } else {
      s += "CONFIG: ImprecisePropagationRule is NOT enabled.\n";
    }
    if (isConcreteTaintCreationRuleOn()) {
      s += "CONFIG: ConcreteTaintPropagationRule is enabled.\n";
      if (isConcreteTaintAtAssignStmtOn()) {
        s += "- ConcreteTaintAtAssignStmtOn is enabled\n";
      } else {
        s += "- ConcreteTaintAtAssignStmtOn is NOT enabled\n";
      }
      if (isConcreteTaintAtReturnStmtOn()) {
        s += "- ConcreteTaintAtReturnStmtOn is enabled\n";
      } else {
        s += "- ConcreteTaintAtReturnStmtOn is NOT enabled\n";
      }
      if (isConcreteTaintAtCalleeOn()) {
        s += "- ConcreteTaintAtCalleeOn is enabled\n";
      } else {
        s += "- ConcreteTaintAtCalleeOn is NOT enabled\n";
      }
    } else {
      s += "CONFIG: ConcreteTaintPropagationRule is NOT enabled.\n";
    }
    if (isStaticFieldPropagationRuleOn()) {
      s += "CONFIG: StaticFieldPropagationRule is enabled.\n";
    } else {
      s += "CONFIG: StaticFieldPropagationRule is NOT enabled.\n";
    }
    if (isStringTaintCreationRuleOn()) {
      s += "CONFIG: StringTaintCreationRule is enabled.\n";
    } else {
      s += "CONFIG: StringTaintCreationRule is NOT enabled.\n";
    }
    if (timeOutOn) {
      s += "CONFIG: Timeout in " + timeOutDuration / 60 + " mins.\n";
    }
    if (writeHtmlOutput) {
      s += "CONFIG: Write results into HTML files.\n";
    }
    if (writeJimpleOutput) {
      s += "CONFIG: Write results into Jimple files.";
    }
    return s;
  }

  /**
   * Sets the write html output.
   *
   * @param writeHtmlOutput the new write html output
   */
  public void setWriteHtmlOutput(boolean writeHtmlOutput) {
    this.writeHtmlOutput = writeHtmlOutput;
  }

  /** Turn on all rules. */
  public void turnOnAllRules() {
    setUIConstraintCreationRuleOn(true);
    setTaintConstraintCreationRuleOn(true);
    setSourceTaintCreationRuleOn(true);
    setTaintPropagationRuleOn(true);
    setImpreciseTaintCreationRuleOn(true);
    setImprecisePropagationRuleOn(true);
    setConcreteTaintCreationRuleOn(true, true, true, true);
    setStaticFieldPropagationRuleOn(true);
  }

  /**
   * Gets the config dir.
   *
   * @return the config dir
   */
  public String getConfigDir() {
    return this.configDir;
  }

  /**
   * Sets the config dir.
   *
   * @param configDir the new config dir
   */
  public void setConfigDir(String configDir) {
    this.configDir = configDir;
  }
}
