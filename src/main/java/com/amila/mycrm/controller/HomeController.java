package com.amila.mycrm.controller;

import com.amila.mycrm.common.JTableUtil;
import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@RestController
public class HomeController {

  private Logger logger = LoggerFactory.getLogger(HomeController.class);

  @Value("${app.name}")
  private String name;

  private CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView getTestString() {
    return new ModelAndView("home");
  }

  //TODO add pagination support
  @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
  public Map<String, Object> getAllCustomers() {
    //TODO revisit logs
    logger.debug("Getting all customers");
    List<CustomerDTO> allCustomers = customerService.getAllCustomers();
    return JTableUtil.getJTableFriendlyResponseObject(allCustomers);
  }

  @RequestMapping(value = "/addNewCustomer", method = RequestMethod.GET)
  public Map<String, Object> addNewCustomer(CustomerDTO customer) {
    logger.debug("add new customer");
    CustomerDTO saved = customerService.saveCustomer(customer);
    return JTableUtil.getJTableFriendlyResponseObject(saved);
  }

  @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
  public Map<String, Object> deleteCustomer(@RequestParam int id) {
    logger.debug("delete customer");
    CustomerDTO deleted = customerService.deleteCustomer(id);
    return JTableUtil.getJTableFriendlyResponseMessage(deleted != null);
  }

  @RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
  public Map<String, Object> updateCustomer(CustomerDTO customer) {
    logger.debug("update customer");
    CustomerDTO updated = customerService.updateCustomer(customer);
    return JTableUtil.getJTableFriendlyResponseObject(updated);
  }
}
