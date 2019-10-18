package com.amila.mycrm.dao.impl;

import com.amila.mycrm.common.HibernateUtil;
import com.amila.mycrm.dao.CustomerDAO;
import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.entities.CustomerEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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


  public CustomerDTO saveCustomer(CustomerDTO customer) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    CustomerEntity customerEntity = new CustomerEntity(customer);
    customerEntity.setActive((byte) 1);
    customerEntity.setCreatedTime(new Date().getTime());
    customerEntity.setUpdatedTime(new Date().getTime());

    Serializable saved = session.save(customerEntity);
    session.getTransaction().commit();

    Integer generatedID = (Integer) saved;
    return new CustomerDTO(customerEntity, generatedID);
  }


  public CustomerDTO deleteCustomer(int id) {
    CustomerDTO deleted = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    CustomerEntity customer = session.get(CustomerEntity.class, id);
    if (customer != null) {
      session.delete(customer);
      deleted = new CustomerDTO(customer);
    }
    session.getTransaction().commit();
    return deleted;
  }


  public CustomerDTO updateCustomer(CustomerDTO customer) {
    CustomerDTO updatedCustomer = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    CustomerEntity saved = session.get(CustomerEntity.class, customer.getId());
    if (saved != null) {
      saved.setName(customer.getName());
      saved.setAddress(customer.getAddress());
      saved.setDepartment(customer.getDepartment());
      saved.setEmail(customer.getEmail());
      saved.setMobile(customer.getMobile());
      saved.setUpdatedTime(new Date().getTime());
      updatedCustomer = new CustomerDTO(saved);
    }
    session.getTransaction().commit();
    return updatedCustomer;
  }
}
