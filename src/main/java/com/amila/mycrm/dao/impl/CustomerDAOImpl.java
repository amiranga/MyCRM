package com.amila.mycrm.dao.impl;

import com.amila.mycrm.common.Constants;
import com.amila.mycrm.common.CustomerEnums.CustomerOperation;
import com.amila.mycrm.common.MyCRMException;
import com.amila.mycrm.dao.CustomerDAO;
import com.amila.mycrm.dto.CustomerDTO;
import com.amila.mycrm.dto.CustomerListDTO;
import com.amila.mycrm.entities.CustomerEntity;
import com.amila.mycrm.entities.LogEntity;
import com.amila.mycrm.util.HibernateUtil;
import com.amila.mycrm.util.LogTableUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author amila
 */
@Service
public class CustomerDAOImpl implements CustomerDAO {

  private Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

  public CustomerListDTO getAllCustomers(int startIndex, int pageSize, String sorting) throws MyCRMException {
    try {
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
    } catch (Exception e) {
      logger.error("Error Occurred when retrieving customer list {}", e);
      throw new MyCRMException("Error Occurred when retrieving customer list", Constants.ErrorMessage.UNKNOWN_ERROR);
    }

  }


  public CustomerDTO saveCustomer(CustomerDTO customer) throws MyCRMException {
    try {
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
    } catch (Exception e) {
      logger.error("Error Occurred when saving customer {}", e);
      throw new MyCRMException("Error Occurred when saving customer", Constants.ErrorMessage.UNKNOWN_ERROR);
    }
  }


  public CustomerDTO deleteCustomer(int id) throws MyCRMException {
    try {
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

    } catch (Exception e) {
      logger.error("Error Occurred when deleting customer {}", e);
      throw new MyCRMException("Error Occurred when deleting customer", Constants.ErrorMessage.UNKNOWN_ERROR);
    }
  }


  public CustomerDTO updateCustomer(CustomerDTO customer) throws MyCRMException {
    try {
      CustomerDTO updatedCustomer = null;
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();

      long now = new Date().getTime();

      CustomerEntity saved = session.get(CustomerEntity.class, customer.getId());
      if (saved != null) {
        saved.setName(customer.getName());
        saved.setAddress(customer.getAddress());
        saved.setDepartment(customer.getDepartment().name());
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

    } catch (Exception e) {
      logger.error("Error Occurred when editing customer {}", e);
      throw new MyCRMException("Error Occurred when editing customer", Constants.ErrorMessage.UNKNOWN_ERROR);
    }
  }
}
