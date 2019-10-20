package com.amila.mycrm.service;

import com.amila.mycrm.common.MyCRMException;
import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.dto.CustomerListDTO;

public interface CustomerService {

  CustomerListDTO getAllCustomers(int startIndex, int pageSize, String sorting) throws MyCRMException;

  CustomerDTO saveCustomer(CustomerDTO customer) throws MyCRMException;

  CustomerDTO deleteCustomer(int id) throws MyCRMException;

  CustomerDTO updateCustomer(CustomerDTO customer) throws MyCRMException;
}
