package com.kollect.tests.data;

import org.junit.Before;
import org.junit.Test;

import com.kollect.etl.dataaccess.AbstractSqlSessionProvider;
import com.kollect.tests.common.DaoProvider;
import com.kollect.tests.common.ReadWriteServiceProvider;

public class CustomerInvoiceTest {
  
  private ReadWriteServiceProvider service;
  
  @Before
  public void runBeforeEachTest() {
    service = new ReadWriteServiceProvider(new DaoProvider(new AbstractSqlSessionProvider("mahb_prod")));
  }
  
  
  @Test
  public void shouldNotContainDuplicateInvoice() {
    
    System.out.println(service.executeQuery("getInvoiceCount", null));
    
  }

}
