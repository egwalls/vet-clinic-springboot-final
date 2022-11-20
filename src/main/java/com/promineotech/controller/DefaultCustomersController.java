package com.promineotech.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.clinic.entity.Customers;
import com.promineotech.service.CustomersService;


@RestController
public class DefaultCustomersController implements CustomersController {

  @Autowired
  private CustomersService customerService;
  
  @Override
  public List<Customers> fetchCustomers(String customerId) {
    return customerService.fetchCustomers(customerId);
  }

  @Override
  public Optional<Customers> createCustomers(String customerId, String fName, String lName,
      String phone, String address) {    
    return customerService.createCustomers(customerId, fName, lName, phone, address);
  }

  @Override
  public Optional<Customers> updateCustomers(String customerId, String fName, String lName,
      String phone, String address) {    
    return customerService.updateCustomers(customerId, fName, lName, phone, address);
  }

  @Override
  public Optional<Customers> deleteCustomers(String customerId) {
    return customerService.deleteCustomers(customerId);
  }

}
