package com.promineotech.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.clinic.entity.Customers;

public interface CustomersDao {

  List<Customers> fetchCustomers(String customerId);

  Optional<Customers> createCustomers(String customerId, String fName, String lName, String phone,
      String address);

  Optional<Customers> updateCustomers(String customerId, String fName, String lName, String phone,
      String address);
  
  Optional<Customers> deleteCustomers(String customerId);
}
