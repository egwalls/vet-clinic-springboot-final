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
import com.promineotech.clinic.entity.Dx;

@Component
public class DefaultDxDao implements DxDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Dx> fetchDx(String dxId) {
    
    String sql = "SELECT * "
        + "FROM dx "
        + "WHERE dx_id = :dx_id";
    
    Map<String,Object> params = new HashMap<>();
    params.put("dx_id", dxId);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Dx mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Dx.builder()
            .dxPk(rs.getLong("dx_pk"))
            .dxId(new String(rs.getString("dx_id")))
            .dxName(new String(rs.getString("dx_name")))
            .description(new String(rs.getString("dx_description")))
            .build();
      }
    });
  }

  @Override
  public Optional<Dx> createDx(String dxId, String dxName, String description) {
    
    String sql = "INSERT INTO dx "
        + "(dx_id, dx_name, dx_description) VALUES "
        + "(:dx_id, :dx_name, :dx_description)";
    
    Map<String, Object> params = allParamsToHashMap(dxId, dxName, description);
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Dx.builder()
        .dxId(dxId)
        .dxName(dxName)
        .description(description)
        .build());
  }

  

  @Override
  public Optional<Dx> updateDx(String dxId, String dxName, String description) {
    
    String sql = "UPDATE dx "
        + "SET dx_name = :dx_name, dx_description = :dx_description "
        + "WHERE dx_id = :dx_id";
    
    Map<String, Object> params = allParamsToHashMap(dxId, dxName, description);
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Dx.builder()
        .dxId(dxId)
        .dxName(dxName)
        .description(description)
        .build());
  }

  @Override
  public Optional<Dx> deleteDx(String dxId, String dxName) {
    
    String sql = "DELETE FROM dx WHERE "
        + "dx_id = :dx_id AND dx_name = :dx_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("dx_id", dxId);
    params.put("dx_name", dxName);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Dx.builder()
        .dxId(dxId)
        .dxName(dxName)
        .build());
  }
  
  /**
   * @param dxId
   * @param dxName
   * @param description
   * @return 
   */
  private Map<String, Object> allParamsToHashMap(String dxId, String dxName, String description) {
    Map<String, Object> params = new HashMap<>();
    params.put("dx_id", dxId);
    params.put("dx_name", dxName);
    params.put("dx_description", description);
    return params;
  }

}
