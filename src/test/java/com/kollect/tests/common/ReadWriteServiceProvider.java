package com.kollect.tests.common;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReadWriteServiceProvider {
  
  private DaoProvider dao;
  
  public ReadWriteServiceProvider(DaoProvider dao) {
    this.dao = dao;
  }
  
  
  private static final Logger LOG = LoggerFactory.getLogger(ReadWriteServiceProvider.class);
  
  
  public List<Object> executeQuery(final String queryName, Object args){
    try {
      return this.dao.executeQuery(queryName,args);
    } catch (PersistenceException persEx) {
      LOG.error("Failed to execute statement: {}",queryName, persEx.getCause());
      throw persEx;
    }
  }
  
  public <T> Iterator<T> executeQueryItr(final String queryName, Object args){
    try {
      return this.dao.executeQueryItr(queryName,args);
    } catch (PersistenceException persEx) {
      LOG.error("Failed to execute statement: {}",queryName, persEx.getCause());
      throw persEx;
    }
  }
  
  public int updateQuery(final String queryName, Object args){
    try {
      return this.dao.updateQuery(queryName,args);
    } catch (PersistenceException persEx) {
      LOG.error("Failed to execute update statement: {}",queryName, persEx.getCause());
      throw persEx;
    }
  }

  public int insertQuery(final String queryName, Object args){
    try {
      return this.dao.insertQuery(queryName,args);
    } catch (PersistenceException persEx) {
      LOG.error("Failed to execute update statement: {}",queryName, persEx.getCause());
      throw persEx;
    }
  }

  
  
  public void batchUpdate(final List<Object> modelList, final String queryName){
    try {
      this.dao.batchUpdate(modelList,queryName);
    } catch (PersistenceException persEx) {
      LOG.error("Failed to execute batch update statement: {}",queryName, persEx.getCause());
      throw persEx;
    }
  }
  
  public void batchInvoice(final List<Object> modelList, final String queryName){
    try {
      this.dao.batchInvoice(modelList,queryName);
    } catch (PersistenceException persEx) {
      LOG.error("Failed to execute batch update statement: {}",queryName, persEx.getCause());
      throw persEx;
    }
  }
  
  
  
  public void batchInsert(final List<Object> modelList, final String queryName){
    try {
      this.dao.batchInsert(modelList,queryName);
    } catch (PersistenceException persEx) {
      LOG.error("Failed to execute batch insert statement: {}",queryName, persEx.getCause());
      throw persEx;
    }
  }
  
  
  

}
