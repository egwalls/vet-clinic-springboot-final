package com.promineotech.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.service.DxService;

@RestController
public class DefaultDxController implements DxController {

  @Autowired
  private DxService dxService;
  
  @Override
  public List<Dx> fetchDx(String dxId) {
    return dxService.fetchDx(dxId);
  }

  @Override
  public Optional<Dx> createDx(String dxId, String dxName, String description) {
    return dxService.createDx(dxId, dxName, description);
  }

  @Override
  public Optional<Dx> updateDx(String dxId, String dxName, String description) {
    return dxService.updateDx(dxId, dxName, description);
  }

  @Override
  public Optional<Dx> deleteDx(String dxId) {
    return dxService.deleteDx(dxId);
  }

}
