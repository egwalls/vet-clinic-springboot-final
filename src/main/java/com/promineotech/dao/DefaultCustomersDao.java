package com.promineotech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.clinic.entity.Customers;

@Component
public class DefaultCustomersDao implements CustomersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Customers> fetchCustomers(String customerId) {
    String sql = ""
        + "SELECT * "
        + "FROM customers "
        + "WHERE customer_id = :customer_id";
    
    Map<String,Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Customers.builder().customerPk(rs.getLong ("customer_pk"))
        .customerId(rs.getString("customer_id"))
        .fName(rs.getString("f_name"))
        .lName(rs.getString("l_name"))
        .phone(rs.getString("phone"))
        .address(rs.getString("address"))
        .build();
        
      }
    }) ;
  }

  @Override
  public Optional<Customers> createCustomers(String customerId, String fName, String lName,
      String phone, String address) {
    
    //use animalId to look up animalFk, use animalFk in SQL statement
    
    
    
    String sql = "INSERT INTO customers "
        + "(customer_id, f_Name, l_Name, phone, address) VALUES "
        + "(:customer_id, :fName, :lName, :phone, :address)";
    
    Map<String, Object> params = allParamsToHashMap(customerId, fName, lName, phone, address);
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Customers.builder()
        .customerId(customerId)
        .fName(fName)
        .lName(lName)
        .phone(phone)
        .address(address)
        .build());
  }

  @Override
  public Optional<Customers> updateCustomers(String customerId, String fName, String lName,
      String phone, String address) {
    
    String sql = "UPDATE customers "
        + "SET f_Name = :fName, l_Name = :lName, phone = :phone, address = :address "
        + "WHERE customer_id = :customer_id";
    Map<String, Object> params = allParamsToHashMap(customerId, fName, lName, phone, address);
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Customers.builder()
        .customerId(customerId)
        .fName(fName)
        .lName(lName)
        .phone(phone)
        .address(address)
        .build());
  }

  @Override
  public Optional<Customers> deleteCustomers(String customerId, String lName) {
    
    String sql = "DELETE FROM customers WHERE "
        + "customer_id = :customer_id AND l_name = :l_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    params.put("l_name", lName);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Customers.builder()
        .customerId(customerId)
        .lName(lName)
        .build());
  }
  
  /**
   * @param customerId
   * @param fName
   * @param lName
   * @param phone
   * @param address
   * @return 
   */
  private Map<String, Object> allParamsToHashMap(String customerId, String fName, String lName, String phone,
      String address) {
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    params.put("fName", fName);
    params.put("lName", lName);
    params.put("phone", phone);
    params.put("address", address);
    return params;
  }

}
