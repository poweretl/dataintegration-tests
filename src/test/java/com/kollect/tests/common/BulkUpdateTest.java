package com.kollect.tests.common;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Before;
import org.junit.Test;


import com.kollect.etl.dataaccess.AbstractSqlSessionProvider;

public class BulkUpdateTest {
  
  //private static final Logger LOG = LoggerFactory.getLogger(BulkUpdateTest.class);
  
  private Service service;
  
  @Before
  public void run_one_per_method() {
    service = new Service(new AbstractSqlSessionProvider("mahb_prod2"));
  }
  
  @Test(expected = PersistenceException.class)
  public void testUpdateThrowsPersistenceException() {
    service.update();
  }
  
  @Test(expected = PersistenceException.class)
  public void testExecuteQuery() {
    service.queryMultipleObjects();
  }

}
