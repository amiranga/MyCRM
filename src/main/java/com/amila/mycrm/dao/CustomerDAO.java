package com.amila.mycrm.dao;

import com.amila.mycrm.dto.CustomerDTO;

import java.util.List;

public interface CustomerDAO {

  List<CustomerDTO> getAllCustomers();

  CustomerDTO saveCustomer(CustomerDTO customer);

  CustomerDTO deleteCustomer(int id);

  CustomerDTO updateCustomer(CustomerDTO customer);
}
