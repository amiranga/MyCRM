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

import java.util.ArrayList;
import java.util.HashMap;
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
    logger.info("Testing logging");
    List<CustomerDTO> allCustomers = customerService.getAllCustomers();
    logger.info(allCustomers.get(0).toString());
    return new ModelAndView("home");
  }

  //FIXME : Get customer data from DB!
  @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
  public Map<String, Object> getAllCustomers() {
    logger.info("Testing logging");
    List<CustomerDTO> allCustomers = new ArrayList<CustomerDTO>();
    for (int i = 0; i < 100; i++) {
      allCustomers.add(new CustomerDTO(i, "C" + i, "D" + i));
    }
    HashMap<String, Object> stringListHashMap = new HashMap<String, Object>();
    stringListHashMap.put("Records", allCustomers);
    stringListHashMap.put("Result", "OK");
    stringListHashMap.put("TotalRecordCount", 100);
    return stringListHashMap;
  }
}
