package com.amila.mycrm.controller;

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
    logger.info("Testing logging");
    List<CustomerDTO> allCustomers = customerService.getAllCustomers();
    logger.info(allCustomers.get(0).toString());
    return new ModelAndView("home");
  }
}
