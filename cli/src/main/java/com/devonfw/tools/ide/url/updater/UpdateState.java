package com.devonfw.tools.ide.url.updater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UpdateState {
  private static int successful = 0;
  private static List failedVersions = new ArrayList<String>();
  private static final Logger updateLogger = LoggerFactory.getLogger(UpdateState.class);


  public UpdateState() {
  }

  public void updateSuccessful(){
    successful++;
  }
  public void updateFailed(String version){
    failedVersions.add(version);
  }
  public void updateMinus(){
    successful--;
  }

  public void log(String tool, String edition){
    if (!failedVersions.isEmpty()) {
      int updateFailCount = failedVersions.size();
      updateLogger.info(tool + "/" + edition + ": successful: " + successful + " ; Failed: "
          + updateFailCount);

      updateLogger.error("Failed Versions: " + failedVersions);
      double successRate = (double) successful / (successful + updateFailCount);
      updateLogger.info("Successrate: " + successRate + "%");
      }
  }
}
