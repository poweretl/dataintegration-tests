package com.kollect.tests.data;

import com.kollect.etl.dataaccess.AbstractSqlSessionProvider;
import com.kollect.tests.common.DaoProvider;
import com.kollect.tests.common.ReadWriteServiceProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class InvoiceTest {

  private ReadWriteServiceProvider service;


  @Before
  public void runBeforeEachTest() {
    service = new ReadWriteServiceProvider(new DaoProvider(new AbstractSqlSessionProvider("mahb_prod")));
  }

  @Test
  public void shouldNotHaveDuplicates(){

  }
  
  public void shouldHaveExactQuantityOfInvoices() {
      Long expectedResult = 300000l;
      @SuppressWarnings("unchecked")
      Map<String, Long> map = (Map<String, Long>) service.executeQuery("getInvoiceCount", null).get(0);
      Long actualResult = map.get("count");
      Assert.assertEquals("Expected and actual are not same", expectedResult, actualResult);
  }

  public void shouldBeTraceableToSourceHash(){

  }

}
