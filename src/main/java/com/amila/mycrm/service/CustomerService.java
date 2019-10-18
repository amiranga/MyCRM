package com.amila.mycrm.service;

import com.amila.mycrm.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

  List<CustomerDTO> getAllCustomers();

  CustomerDTO saveCustomer(CustomerDTO customer);

  CustomerDTO deleteCustomer(int id);

  CustomerDTO updateCustomer(CustomerDTO customer);
}
