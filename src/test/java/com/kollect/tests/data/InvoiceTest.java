package com.kollect.tests.data;

//given-when-then

import com.kollect.etl.dataaccess.AbstractSqlSessionProvider;
import com.kollect.tests.common.DaoProvider;
import com.kollect.tests.common.ReadWriteServiceProvider;
import org.junit.Before;

public class InvoiceTest {

  private ReadWriteServiceProvider service;


  @Before
  public void runBeforeEachTest() {
    service = new ReadWriteServiceProvider(new DaoProvider(new AbstractSqlSessionProvider("mahb_prod")));
  }
  
  void shouldNotHaveDuplicates(){

  }
  
  void shouldHaveExactQuantityOfInvoices() {

  }

  void shouldBeTraceableToSourceHash(){

  }




  
  

}
