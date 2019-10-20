package com.amila.mycrm.controller;

import com.amila.mycrm.common.MyCRMException;
import com.amila.mycrm.common.Validator;
import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.dto.CustomerListDTO;
import com.amila.mycrm.dto.GridSettingsDTO;
import com.amila.mycrm.service.CustomerService;
import com.amila.mycrm.util.JTableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class HomeController {

  private Logger logger = LoggerFactory.getLogger(HomeController.class);

  private CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView getTestString() {
    return new ModelAndView("home");
  }

  @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
  public Map<String, Object> getAllCustomers(GridSettingsDTO gridSettings) {
    logger.debug("loading customer list {}", gridSettings);
    try {
      CustomerListDTO customerList = customerService.getAllCustomers(
          gridSettings.getJtStartIndex(), gridSettings.getJtPageSize(), gridSettings.getJtSorting());
      return JTableUtil.formatList(customerList.getCustomers(), customerList.getTotal());
    } catch (MyCRMException e) {
      return JTableUtil.getErrorResponse(e.getUserFriendlyMessage());
    }
  }

  @RequestMapping(value = "/addNewCustomer", method = RequestMethod.GET)
  public Map<String, Object> addNewCustomer(CustomerDTO customer) {
    logger.debug("add new customer request {}", customer);
    try {
      Validator.validateAddEditCustomerRequest(customer);
      CustomerDTO saved = customerService.saveCustomer(customer);
      return JTableUtil.formatSingleResult(saved);
    } catch (MyCRMException e) {
      return JTableUtil.getErrorResponse(e.getUserFriendlyMessage());
    }
  }

  @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
  public Map<String, Object> deleteCustomer(@RequestParam int id) {
    logger.debug("delete new customer request id = {}", id);
    try {
      customerService.deleteCustomer(id);
      return JTableUtil.getSuccessResponse();
    } catch (MyCRMException e) {
      return JTableUtil.getErrorResponse(e.getUserFriendlyMessage());
    }
  }

  @RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
  public Map<String, Object> updateCustomer(CustomerDTO customer) {
    logger.debug("update new customer request {}", customer);
    try {
      Validator.validateAddEditCustomerRequest(customer);
      CustomerDTO updated = customerService.updateCustomer(customer);
      return JTableUtil.formatSingleResult(updated);
    } catch (MyCRMException e) {
      return JTableUtil.getErrorResponse(e.getUserFriendlyMessage());
    }
  }
}
