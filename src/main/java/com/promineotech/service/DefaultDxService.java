package com.promineotech.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.dao.DxDao;

@Service
public class DefaultDxService implements DxService {

  @Autowired
  private DxDao dxDao;

  @Transactional(readOnly = true)
  @Override
  public List<Dx> fetchDx(String dxId) {
    return dxDao.fetchDx(dxId);
  }

  @Override
  public Optional<Dx> createDx(String dxId, String dxName, String description) {
    return dxDao.createDx(dxId, dxName, description);
  }

  @Override
  public Optional<Dx> updateDx(String dxId, String dxName, String description) {    
    return dxDao.updateDx(dxId, dxName, description);
  }

  @Override
  public Optional<Dx> deleteDx(String dxId) {
    return dxDao.deleteDx(dxId);
  }

}
