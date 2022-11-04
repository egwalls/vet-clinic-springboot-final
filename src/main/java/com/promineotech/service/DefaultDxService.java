package com.promineotech.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.dao.DxDao;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultDxService implements DxService {

  @Autowired
  private DxDao dxDao;

  @Transactional(readOnly = true)
  @Override
  public List<Dx> fetchDx(String dxId) {
    log.info("fetchDx method was called from service layer with dxId = {}", dxId);

    return dxDao.fetchDx(dxId);
  }

  @Override
  public Optional<Dx> createDx(String dxId, String dxName, String description) {
    log.info("createDx method was called from service layer with dxId = {}, dxName = {} "
        + "and description = {}", dxId, dxName, description);

    return dxDao.createDx(dxId, dxName, description);
  }

  @Override
  public Optional<Dx> updateDx(String dxId, String dxName, String description) {
    log.info("updateDx method was called from service layer with dxId = {}, dxName = {} "
        + "and description = {}", dxId, dxName, description);
    
    return dxDao.updateDx(dxId, dxName, description);
  }

  @Override
  public Optional<Dx> deleteDx(String dxId, String dxName) {
    log.info("deleteDx method was called from service layer with dxId = {} and dxName = {}"
        , dxId, dxName);

    
    return dxDao.deleteDx(dxId, dxName);
  }

}
