package com.devonfw.tools.ide.url.model.folder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UrlErrorReport {

  private static final UrlErrorReport instance = new UrlErrorReport();
  private static UrlErrorReport getInstance() {
    return instance;
  }
  public static List<UrlErrorState> urlErrorStates = new ArrayList<>();

  private static UrlErrorState addErrorState(String toolWithEdition) {
    UrlErrorState state = new UrlErrorState(toolWithEdition);
    urlErrorStates.add(state);
    return state;
  }

  public static UrlErrorState getErrorState(String toolWithEdition){
    if (!urlErrorStates.isEmpty()) {
      for (UrlErrorState state : urlErrorStates) {
        if (state.getToolWithEdition().equals(toolWithEdition)) {
          return state;
        } else {
          return addErrorState(toolWithEdition);
        }
      }
    } else {
      return addErrorState(toolWithEdition);
    }
    return null;
  }

  public static String getReport() {
    StringBuilder report = new StringBuilder();
    report.append("ERROR REPORT FROM: ").append(LocalDateTime.now()).append("\n");
    for (UrlErrorState state : urlErrorStates) {
      if (!state.getAdditionFailures().isEmpty() || !state.getVerificationFailures().isEmpty()){
      report.append(state.toString()).append("\n");
      }
    }
    report.append("ERROR REPORT ENDS").append("\n");
    return report.toString();
  }
}
