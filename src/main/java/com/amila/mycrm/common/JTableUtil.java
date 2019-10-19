package com.amila.mycrm.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JTableUtil {

  public static <T> Map<String, Object> getJTableFriendlyResponseObject(T result, Long resultCount) {
    HashMap<String, Object> output = new HashMap<String, Object>();
    output.put("Result", "OK");
    if (result instanceof List) {
      output.put("Records", result);
      output.put("TotalRecordCount", resultCount != null ? resultCount : ((List) result).size());
    } else {
      output.put("Record", result);
    }
    return output;
  }

  public static Map<String, Object> getJTableFriendlyResponseMessage(boolean isSuccess) {
    HashMap<String, Object> output = new HashMap<String, Object>();
    output.put("Result", isSuccess ? "OK" : "ERROR");
    return output;
  }
}
