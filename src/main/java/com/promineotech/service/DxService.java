package com.promineotech.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.clinic.entity.Dx;

public interface DxService {
  
  List<Dx> fetchDx (String dxId);
  
  Optional<Dx> createDx(String dxId, String dxName, String description);
  
  Optional<Dx> updateDx(String dxId, String dxName, String description);
  
  Optional<Dx> deleteDx(String dxId);
}
