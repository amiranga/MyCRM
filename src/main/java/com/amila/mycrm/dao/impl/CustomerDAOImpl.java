package com.amila.mycrm.dao.impl;

import com.amila.mycrm.common.HibernateUtil;
import com.amila.mycrm.dao.CustomerDAO;
import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.entities.CustomerEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDAOImpl implements CustomerDAO {

  public List<CustomerDTO> getAllCustomers() {
    Session session = HibernateUtil.getSessionFactory().openSession();

    session.beginTransaction();

    Query q = session.createQuery("From CustomerEntity ");

    List<CustomerEntity> resultList = q.list();
    List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
    System.out.println("num of employess:" + resultList.size());
    for (CustomerEntity next : resultList) {
      customers.add(new CustomerDTO(next));
    }
    return customers;
  }
}
