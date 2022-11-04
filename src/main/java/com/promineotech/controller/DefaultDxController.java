package com.promineotech.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.service.DxService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDxController implements DxController {

  @Autowired
  private DxService dxService;
  
  @Override
  public List<Dx> fetchDx(String dxId) {
    log.info("fetchDx was called from the controller layer");
    
    return dxService.fetchDx(dxId);
  }

  @Override
  public Optional<Dx> createDx(String dxId, String dxName, String description) {
    log.info("createDx was called from the controller layer");
    
    return dxService.createDx(dxId, dxName, description);
  }

  @Override
  public Optional<Dx> updateDx(String dxId, String dxName, String description) {
    log.info("updateDx was called from the controller layer");

    return dxService.updateDx(dxId, dxName, description);
  }

  @Override
  public Optional<Dx> deleteDx(String dxId, String dxName) {
    log.info("deleteDx was called from the controller layer");

    return dxService.deleteDx(dxId, dxName);
  }

}
