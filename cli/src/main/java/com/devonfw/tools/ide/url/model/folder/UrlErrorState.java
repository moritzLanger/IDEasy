package com.devonfw.tools.ide.url.model.folder;

import java.util.ArrayList;
import java.util.List;

public final class UrlErrorState {

  private final String toolWithEdition;
  private int additionSuccesses;
  private static List additionFailures;
  private int verificationSuccesses;
  private List verificationFailures;

  public UrlErrorState(String toolWithEdition) {

    this.toolWithEdition = toolWithEdition;
    this.additionSuccesses = 0;
    this.additionFailures = new ArrayList<String>();
    this.verificationSuccesses = 0;
    this.verificationFailures = new ArrayList<String>();
  }

  public String getToolWithEdition() {

    return toolWithEdition;
  }

  public int getAdditionSuccesses() {

    return additionSuccesses;
  }

  public void setAdditionSuccesses(int additionSuccesses) {

    this.additionSuccesses = additionSuccesses;
  }

  public List getAdditionFailures() {

    return additionFailures;
  }

  public void setAdditionFailures(List additionFailures) {

    this.additionFailures = UrlErrorState.additionFailures;
  }

  public int getVerificationSuccesses() {

    return verificationSuccesses;
  }

  public void setVerificationSuccesses(int verificationSuccesses) {

    this.verificationSuccesses = verificationSuccesses;
  }

  public List getVerificationFailures() {

    return verificationFailures;
  }

  public void setVerificationFailures(List verificationFailures) {

    this.verificationFailures = verificationFailures;
  }

  private int getTotalAdditions() {
    return this.additionFailures.size() + this.additionSuccesses;
  }
  private int getTotalVerification() {
    return this.verificationFailures.size() + this.verificationSuccesses;
  }

  private String getErrorRate(int failures, int totals) {
    if (failures == 0) {
      return "0.00";
    } else {
      double errorRate = (double) failures / totals * 100;
      return String.format("%.2f", errorRate);
    }
  }
  public void updateAdditions(boolean success, String version) {
    if (success) {
      this.additionSuccesses ++;
    } else {
      this.additionFailures.add(version);
    }
  }

  public void updateVerifications(boolean success, String version) {
    if (success) {
      this.verificationSuccesses ++;
    } else {
      this.verificationFailures.add(version);
    }
  }
  public void subtractVerification(){
    this.verificationSuccesses --;
  }
  @Override
  public String toString() {

    String additionState = "versions added: " + getAdditionFailures().size() + " failed, " + getAdditionSuccesses() + " succeeded, "
        + getTotalAdditions() + " total, " + getErrorRate(getAdditionFailures().size(), getTotalAdditions()) + "% error. Failed versions list: " + getAdditionFailures();

    String verificationState = " - versions verified: " + getVerificationFailures().size() + " failed, " + getVerificationSuccesses() +
        " succeeded, " + getTotalVerification() + " total, " + getErrorRate(getVerificationFailures().size(), getTotalVerification()) + "% error. Failed versions list:" + getVerificationFailures() + System.lineSeparator();

    return getToolWithEdition() + ": " + additionState + verificationState;
  }
}
