package com.promineotech.dao;

/*
 * This class collects methods which are referenced in methods across 
 * the dao layer. This class is then autowired where necessary so the
 * following methods can be referenced. This helped keep the classes 
 * more organized.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Customers;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.clinic.entity.Dx_animal;
import com.promineotech.clinic.entity.Species;


@Component
public class DefaultDaoSupport implements DaoSupport {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  
  /*
   * CUSTOMER FUNCTIONS
   */
  
  public Optional<Customers> fetchCustomerOptional(String customerId) {
    String sql = ""
        + "SELECT * "
        + "FROM customers "
        + "WHERE customer_id = :customer_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
    
  }
  
  public Customers getCustomer(String customerId) {
    return fetchCustomerOptional(customerId)
        .orElseThrow(() -> new NoSuchElementException("Customer with ID " + customerId + "does not"
            + " exist."));
  }
  
  public Customers getCustomerByFk(Long customerFk) {
    return fetchCustomerByFk(customerFk)
        .orElseThrow(() -> new NoSuchElementException("Animal with ID " + " does not"
            + " exist."));
  }
  
  public Optional<Customers> fetchCustomerByFk(Long customerFk) {
    String sql = ""
        + "SELECT * "
        + "FROM customers "
        + "WHERE customer_pk = :customer_fk";
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_fk", customerFk);
    
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
    
  }
  
  /*
   * ANIMAL FUNCTIONS
   */
  
  public Optional<Animals> fetchAnimalOptional(String animalId) {
    String sql = ""
        + "SELECT * "
        + "FROM animals "
        + "WHERE animal_id = :animal_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("animal_id", animalId);
    
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new AnimalResultSetExtractor()));
  
  }
  
  public Animals getAnimal(String animalId) {
    return fetchAnimalOptional(animalId)
        .orElseThrow(() -> new NoSuchElementException("Customer with ID " + animalId + "does not"
            + " exist."));
  }
  
  public Optional<Animals> fetchAnimalByFk(Long animalFk) {
    String sql = ""
        + "SELECT * "
        + "FROM animals "
        + "WHERE animal_pk = :animal_fk";
    
    Map<String, Object> params = new HashMap<>();
    params.put("animal_fk", animalFk);
    

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new AnimalResultSetExtractor()));
  }
  
  public Animals getAnimalByFk(Long animalFk) {
    return fetchAnimalByFk(animalFk).orElseThrow(() -> new NoSuchElementException(
        "Animal with ID = " + animalFk + " was not found."));
  }
  
  /*
   * DX FUNCTIONS
   */
  public Optional<Dx> fetchDx(String dxId) {
    String sql = ""
        + "SELECT * "
        + "FROM dx "
        + "WHERE dx_id = :dx_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("dx_id", dxId);
    
    

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new DxResultSetExtractor()));
  }
  
  public Dx getDx(String dxId) {
    return fetchDx(dxId).orElseThrow(() -> new NoSuchElementException(
        "Dx with ID = " + dxId + " was not found."));
  }
  
  public Optional<Dx> fetchDxByFk(Long dxFk) {
    String sql = ""
        + "SELECT * "
        + "FROM dx "
        + "WHERE dx_pk = :dx_fk";
    
    Map<String, Object> params = new HashMap<>();
    params.put("dx_fk", dxFk);
    

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new DxResultSetExtractor()));
  }
  
  public Dx getDxByFk(Long dxFk) {
    return fetchDxByFk(dxFk).orElseThrow(() -> new NoSuchElementException(
        "Dk with ID = " + dxFk + " was not found."));
  }
  
  /*
   * DX_ANIMAL FUNCTIONS    
   */
  
  @Override
  public Optional<Dx_animal> fetchDxAnimal(String dxAnimalId) {
    String sql = ""
        + "SELECT * "
        + "FROM dx_animal "
        + "WHERE dx_animal_id = :dx_animal_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("dx_animal_id", dxAnimalId);
    
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new DxAnimalResultSetExtractor()));
  
  }
  

  @Override
  public Dx_animal getDxAnimal(String dxAnimalId) {
    return fetchDxAnimal(dxAnimalId).orElseThrow(() -> new NoSuchElementException(
        "Dx_animal with ID = " + dxAnimalId + " was not found."));
  }

  
  
  /*
   * RESULT SET EXTRACTORS
   */
  
  public class AnimalResultSetExtractor implements ResultSetExtractor<Animals> {
    @Override
    public Animals extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      Long l = rs.getLong("customer_fk");
      Customers customer = null;
      if (l != 0) {
        customer = getCustomerByFk(l);
      }
      return Animals.builder()
          .animalPk(rs.getLong("animal_pk"))
          .animalId(rs.getString("animal_id"))
          .animalName(rs.getString("animal_name"))
          .species(Species.valueOf(rs.getString("species")))
          .breed(rs.getString("breed"))
          .symptoms(rs.getString("symptoms"))
          .customer(customer)
          .build();
    }
  }
  
  class DxResultSetExtractor implements ResultSetExtractor<Dx> {
    @Override
    public Dx extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      
      return Dx.builder()
          .dxPk(rs.getLong("dx_pk"))
          .dxId(new String(rs.getString("dx_id")))
          .dxName(new String(rs.getString("dx_name")))
          .description(new String(rs.getString("dx_description")))
          .build();
    }
  }
  
  class CustomerResultSetExtractor implements ResultSetExtractor<Customers> {
    @Override
    public Customers extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      
      return Customers.builder()
          .customerPk(rs.getLong ("customer_pk"))
          .customerId(rs.getString("customer_id"))
          .fName(rs.getString("f_name"))
          .lName(rs.getString("l_name"))
          .phone(rs.getString("phone"))
          .address(rs.getString("address"))
          .build();
    }
  }
  
  class DxAnimalResultSetExtractor implements ResultSetExtractor<Dx_animal> {
    @Override
    public Dx_animal extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      
//      if (rs.getLong("dx_animal_pk") == 0) {
//        return null;
//      }
      return Dx_animal.builder()
          .dxAnimalPk(rs.getLong("dx_animal_pk"))
          .dxAnimalId(rs.getString("dx_animal_id"))
          .animalObj(getAnimalByFk(rs.getLong("animal_fk")))
          .dxObj(getDxByFk(rs.getLong("dx_fk")))
          .build();
    }
  }
  
}
