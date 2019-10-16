package com.amila.mycrm.service.impl;


import com.amila.mycrm.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
  public String getCustomers(String text) {
    return "dummy";
  }
}
