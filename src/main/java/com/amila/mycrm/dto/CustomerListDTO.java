package com.amila.mycrm.dto;

import java.util.List;

public class CustomerListDTO {

  private List<CustomerDTO> customers;
  private Long total;

  public CustomerListDTO(List<CustomerDTO> customers, Long total) {
    this.customers = customers;
    this.total = total;
  }

  public List<CustomerDTO> getCustomers() {
    return customers;
  }

  public void setCustomers(List<CustomerDTO> customers) {
    this.customers = customers;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }
}
