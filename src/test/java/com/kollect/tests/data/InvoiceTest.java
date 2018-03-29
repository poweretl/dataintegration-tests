package com.kollect.tests.data;

import com.kollect.etl.dataaccess.AbstractSqlSessionProvider;
import com.kollect.tests.common.DaoProvider;
import com.kollect.tests.common.ReadWriteServiceProvider;
import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InvoiceTest {

  private ReadWriteServiceProvider service;


  @Before
  public void runBeforeEachTest() {
    service = new ReadWriteServiceProvider(new DaoProvider(new AbstractSqlSessionProvider("mahb_prod")));
  }

  @Test
  public void shouldNotHaveDuplicates(){
      Long expectedCount = 0L; //this value comes from json
      Long actualResult = 0L;

      if (service.executeQuery("getInvoiceUnique", null).size() > 0){
          @SuppressWarnings("unchecked")
          Map<String, Long> m = (Map) service.executeQuery("getInvoiceUnique", null);
          actualResult = m.get("count");
      }
      Assert.assertEquals(expectedCount, actualResult);
  }

  @Test
  public void shouldHaveExactQuantityOfInvoices() {
      Long expectedResult = 300000l; //this value comes from json
      @SuppressWarnings("unchecked")
      Map<String, Long> map = (Map<String, Long>) service.executeQuery("getInvoiceCount", null).get(0);
      Long actualResult = map.get("count");
      Assert.assertEquals("Expected and actual are not same", expectedResult, actualResult);
  }

  @Test
  public void shouldBeTraceableToSourceHash(){
      String source_hash = "c56f50794c882dc2dfc0692e2816a602c9c1f0e1c238a6272d3b4a7fe5a245fa"; //this value comes from json
      Long expectedResult = 1l;
      @SuppressWarnings("unchecked")
      Map<String, Long> map = (Map<String, Long>) service.executeQuery("getInvoiceTrace", source_hash).get(0);
      Long actualResult = map.get("count");
      Assert.assertEquals("Expected and actual are not same", expectedResult, actualResult);
  }

}
