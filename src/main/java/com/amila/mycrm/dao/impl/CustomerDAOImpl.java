package com.amila.mycrm.dao.impl;

import com.amila.mycrm.common.CustomerEnums.CustomerOperation;
import com.amila.mycrm.dao.CustomerDAO;
import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.dto.CustomerListDTO;
import com.amila.mycrm.entities.CustomerEntity;
import com.amila.mycrm.entities.LogEntity;
import com.amila.mycrm.util.HibernateUtil;
import com.amila.mycrm.util.LogTableUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerDAOImpl implements CustomerDAO {

  public CustomerListDTO getAllCustomers(int startIndex, int pageSize, String sorting) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    String queryStr = "From CustomerEntity c ORDER BY c." + sorting;
    Query custQuery = session.createQuery(queryStr).setFirstResult(startIndex).setMaxResults(pageSize);
    List<CustomerEntity> resultList = custQuery.list();
    List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
    System.out.println("num of employess:" + resultList.size());
    for (CustomerEntity next : resultList) {
      customers.add(new CustomerDTO(next));
    }

    Query countQuery = session.createQuery("Select count(*) From CustomerEntity");
    Long totalCustCount = (Long) countQuery.uniqueResult();
    return new CustomerListDTO(customers, totalCustCount);
  }


  public CustomerDTO saveCustomer(CustomerDTO customer) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    long now = new Date().getTime();

    CustomerEntity customerEntity = new CustomerEntity(customer);
    customerEntity.setActive((byte) 1);
    customerEntity.setCreatedTime(now);
    customerEntity.setUpdatedTime(now);

    Integer newCustId = 0;
    Serializable saved = session.save(customerEntity);
    if (saved != null) {
      newCustId = (Integer) saved;

      CustomerOperation operation = CustomerOperation.ADD;
      LogEntity log = new LogEntity(now, operation.name(), LogTableUtil.generateLog(operation, newCustId));
      session.save(log);
    }

    session.getTransaction().commit();

    return new CustomerDTO(customerEntity, newCustId);
  }


  public CustomerDTO deleteCustomer(int id) {
    CustomerDTO deleted = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    CustomerEntity customer = session.get(CustomerEntity.class, id);
    if (customer != null) {
      session.delete(customer);
      deleted = new CustomerDTO(customer);

      CustomerOperation operation = CustomerOperation.DELETE;
      LogEntity log = new LogEntity(new Date().getTime(), operation.name(), LogTableUtil.generateLog(operation, id));
      session.save(log);
    }
    session.getTransaction().commit();
    return deleted;
  }


  public CustomerDTO updateCustomer(CustomerDTO customer) {
    CustomerDTO updatedCustomer = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    long now = new Date().getTime();

    CustomerEntity saved = session.get(CustomerEntity.class, customer.getId());
    if (saved != null) {
      saved.setName(customer.getName());
      saved.setAddress(customer.getAddress());
      saved.setDepartment(customer.getDepartment());
      saved.setEmail(customer.getEmail());
      saved.setMobile(customer.getMobile());
      saved.setUpdatedTime(now);
      updatedCustomer = new CustomerDTO(saved);

      CustomerOperation operation = CustomerOperation.EDIT;
      LogEntity log = new LogEntity(now, operation.name(), LogTableUtil.generateLog(operation, customer.getId()));
      session.save(log);
    }
    session.getTransaction().commit();
    return updatedCustomer;
  }
}
