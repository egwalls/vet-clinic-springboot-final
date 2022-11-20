package com.promineotech.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.clinic.entity.Customers;
import com.promineotech.dao.CustomersDao;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCustomersService implements CustomersService {

  @Autowired
  private CustomersDao customersDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Customers> fetchCustomers(String customerId) {
    return customersDao.fetchCustomers(customerId);
  }

  @Override
  public Optional<Customers> createCustomers(String customerId, String fName, String lName,
      String phone, String address) {
    return customersDao.createCustomers(customerId, fName, lName, phone, address);
  }

  @Override
  public Optional<Customers> updateCustomers(String customerId, String fName, String lName,
      String phone, String address) {    
    return customersDao.updateCustomers(customerId, fName, lName, phone, address);
  }

  @Override
  public Optional<Customers> deleteCustomers(String customerId) {    
    return customersDao.deleteCustomers(customerId);
  }

}
