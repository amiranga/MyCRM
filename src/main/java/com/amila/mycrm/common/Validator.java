package com.amila.mycrm.common;

import com.amila.mycrm.dto.CustomerDTO;
import org.apache.commons.lang3.StringUtils;

public class Validator {

  public static void validateAddEditCustomerRequest(CustomerDTO customer) throws MyCRMException {
    if (StringUtils.isEmpty(customer.getName())) {
      throw new MyCRMException("No Name attribute in add new customer request", Constants.ErrorMessage.MISSING_NAME_ATTRIBUTE);
    }
  }

}
