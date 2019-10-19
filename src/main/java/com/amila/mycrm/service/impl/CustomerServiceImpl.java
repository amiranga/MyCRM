package com.amila.mycrm.service.impl;

import com.amila.mycrm.dao.CustomerDAO;
import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.dto.CustomerListDTO;
import com.amila.mycrm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerDAO customerDAO;

  @Autowired
  public void setCustomerDAO(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

  public CustomerListDTO getAllCustomers(int startIndex, int pageSize, String sorting) {
    return customerDAO.getAllCustomers(startIndex, pageSize, sorting);
  }

  public CustomerDTO saveCustomer(CustomerDTO customer) {
    return customerDAO.saveCustomer(customer);
  }

  public CustomerDTO deleteCustomer(int id) {
    return customerDAO.deleteCustomer(id);
  }

  public CustomerDTO updateCustomer(CustomerDTO customer) {
    return customerDAO.updateCustomer(customer);
  }
}
