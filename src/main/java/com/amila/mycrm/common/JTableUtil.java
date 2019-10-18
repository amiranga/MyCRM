package com.amila.mycrm.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JTableUtil {

  public static <T> Map<String, Object> getJTableFriendlyResponse(T result) {
    HashMap<String, Object> output = new HashMap<String, Object>();
    output.put("Result", "OK");
    if (result instanceof List) {
      output.put("Records", result);
      output.put("TotalRecordCount", ((List) result).size());
    } else {
      output.put("Record", result);
    }
    return output;
  }
}
