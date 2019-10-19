package com.amila.mycrm.util;

import com.amila.mycrm.common.CustomerEnums.CustomerOperation;

public class LogTableUtil {

  public static String generateLog(CustomerOperation operation, int id) {
    StringBuilder message = new StringBuilder();
    message.append("Customer id = ").append(id).append(" is ");
    switch (operation) {
      case ADD:
        message.append("added.");
        break;
      case EDIT:
        message.append("edited.");
        break;
      case DELETE:
        message.append("deleted.");
        break;
      default:
        break;
    }
    return message.toString();
  }

}
