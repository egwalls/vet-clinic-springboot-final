package com.promineotech.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.clinic.entity.Customers;
import com.promineotech.service.CustomersService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultCustomersController implements CustomersController {

  @Autowired
  private CustomersService customerService;
  
  @Override
  public List<Customers> fetchCustomers(String customerId) {
    log.info("fetchCustomers was called from the controller layer");
    return customerService.fetchCustomers(customerId);
  }

  @Override
  public Optional<Customers> createCustomers(String customerId, String fName, String lName,
      String phone, String address) {
    log.info("createCustomers was called from the controller layer");
    
    return customerService.createCustomers(customerId, fName, lName, phone, address);
  }

  @Override
  public Optional<Customers> updateCustomers(String customerId, String fName, String lName,
      String phone, String address) {
    log.info("updateCustomers was called from the controller layer");
    
    return customerService.updateCustomers(customerId, fName, lName, phone, address);
  }

  @Override
  public Optional<Customers> deleteCustomers(String customerId, String lName) {
    log.info("deleteCustomers was called from the controller layer");
    
    return customerService.deleteCustomers(customerId, lName);
  }

}
