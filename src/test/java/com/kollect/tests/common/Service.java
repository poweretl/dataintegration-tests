package com.kollect.tests.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kollect.etl.dataaccess.IAbstractSqlSessionProvider;

public class Service {
  
  private static final Logger LOG = LoggerFactory.getLogger(Service.class);
  IAbstractSqlSessionProvider daoProvider;
  
  public Service(IAbstractSqlSessionProvider daoProvider) {
    this.daoProvider = daoProvider;
  }
  
  public void queryObject () {
    List<Object> list= daoProvider.queryObject("getCfmastCustomer", null);
    for (Object object : list) {
      @SuppressWarnings("unchecked")
      Map<String, Object> map = (Map<String, Object>) object;
      LOG.debug("{}|{}|{}", map.get("cfcifn"),map.get("cfssno"),map.get("cfsex"));
      
    }
  }
  
  public void queryObject2() {
    daoProvider.queryObject("getUpdatedCustomer", null);
  }

  public void queryMultipleObjects() {
    daoProvider.queryMultipleObjects("getUpdatedCustomer", null);
  }
  
  public void update() throws PersistenceException {
    daoProvider.update("updateCosecLineOfBusiness", 65);
  }

  public void insert(){
    daoProvider.delete("deleteDuplicateCustomer", null);
  }
  

}
