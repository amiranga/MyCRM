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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@RestController
public class HomeController {

  Logger logger = LoggerFactory.getLogger(HomeController.class);

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

  @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
  public Map<String, Object> getAllCustomers() {
    logger.debug("Getting all customers");
    List<CustomerDTO> allCustomers = customerService.getAllCustomers();
    return JTableUtil.getJTableFriendlyResponse(allCustomers);
  }

  @RequestMapping(value = "/addNewCustomer", method = RequestMethod.GET)
  public Map<String, Object> addNewCustomer(CustomerDTO customer) {
    logger.debug("Getting all customers");
    CustomerDTO saved = customerService.saveCustomer(customer);
    return JTableUtil.getJTableFriendlyResponse(saved);
  }
}
