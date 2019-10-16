package com.amila.mycrm.dao;

import com.amila.mycrm.dto.CustomerDTO;

import java.util.List;

public interface CustomerDAO {

    public List<CustomerDTO> getAllCustomers();
}
