package com.kollect.tests.common;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.kollect.etl.dataaccess.IAbstractSqlSessionProvider;




public class DaoProvider {
  
  private IAbstractSqlSessionProvider sqlSessionProvider;

  public DaoProvider(IAbstractSqlSessionProvider sqlSessionProvider) {
    this.sqlSessionProvider = sqlSessionProvider;
  }
  
  public int insertQuery (final String queryName, Object object) throws PersistenceException {
    return sqlSessionProvider.insert(queryName, object);
}
  
  public int updateQuery (final String queryName, Object object) throws PersistenceException {
    return sqlSessionProvider.update(queryName, object);
}
  
  public List<Object> executeQuery(final String queryName, Object args)  throws PersistenceException {
    return sqlSessionProvider.queryObject(queryName, args);
  }
  
  public <T> Iterator<T> executeQueryItr(final String queryName, Object args) throws PersistenceException {
    return sqlSessionProvider.query(queryName, args);
  }
  
  public void batchInsert(final List<Object> modelList, final String queryName) throws PersistenceException  {
    sqlSessionProvider.batchInsert(modelList, queryName);
  }
  
  public void batchUpdate(final List<Object> modelList, final String queryName) throws PersistenceException  {
    sqlSessionProvider.batchUpdate(modelList, queryName);
  }
  
  public void batchInvoice(final List<Object> modelList, final String queryName) throws PersistenceException  {
    sqlSessionProvider.batchInvoice(modelList, queryName, false);
  }
  
  
  

}
