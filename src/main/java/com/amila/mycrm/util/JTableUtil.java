package com.amila.mycrm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JTableUtil {

  public static <T extends List> Map<String, Object> formatList(T result, Long resultCount) {
    HashMap<String, Object> output = new HashMap<String, Object>();
    output.put("Result", "OK");
    if (result != null) {
      output.put("Records", result);
      output.put("TotalRecordCount", resultCount != null ? resultCount : result.size());
    }
    return output;
  }

  public static <T> Map<String, Object> formatSingleResult(T result) {
    HashMap<String, Object> output = new HashMap<String, Object>();
    output.put("Result", "OK");
    output.put("Record", result);
    return output;
  }

  public static Map<String, Object> getErrorResponse(String message) {
    HashMap<String, Object> output = new HashMap<String, Object>();
    output.put("Result", "ERROR");
    output.put("Message", message);
    return output;
  }

  public static Map<String, Object> getSuccessResponse() {
    HashMap<String, Object> output = new HashMap<String, Object>();
    output.put("Result", "OK");
    return output;
  }
}
