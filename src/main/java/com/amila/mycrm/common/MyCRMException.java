package com.amila.mycrm.common;

/**
 * @author amila
 * <p>
 * Wrapper for Java Eception
 */
public class MyCRMException extends Exception {

  private String logMessage;
  private String userFriendlyMessage;

  public MyCRMException(String logMessage, String userFriendlyMessage) {
    super(logMessage);
    this.logMessage = logMessage;
    this.userFriendlyMessage = userFriendlyMessage;
  }

  public String getLogMessage() {
    return logMessage;
  }

  public void setLogMessage(String logMessage) {
    this.logMessage = logMessage;
  }

  public String getUserFriendlyMessage() {
    return userFriendlyMessage;
  }

  public void setUserFriendlyMessage(String userFriendlyMessage) {
    this.userFriendlyMessage = userFriendlyMessage;
  }
}
