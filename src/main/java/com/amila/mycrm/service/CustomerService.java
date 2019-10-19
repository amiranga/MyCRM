package com.amila.mycrm.service;

import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.dto.CustomerListDTO;

public interface CustomerService {

  CustomerListDTO getAllCustomers(int startIndex, int pageSize, String sorting);

  CustomerDTO saveCustomer(CustomerDTO customer);

  CustomerDTO deleteCustomer(int id);

  CustomerDTO updateCustomer(CustomerDTO customer);
}
