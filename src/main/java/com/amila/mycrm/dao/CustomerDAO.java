package com.amila.mycrm.dao;

import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.dto.CustomerListDTO;

public interface CustomerDAO {

  CustomerListDTO getAllCustomers(int startIndex, int pageSize, String sorting);

  CustomerDTO saveCustomer(CustomerDTO customer);

  CustomerDTO deleteCustomer(int id);

  CustomerDTO updateCustomer(CustomerDTO customer);
}
