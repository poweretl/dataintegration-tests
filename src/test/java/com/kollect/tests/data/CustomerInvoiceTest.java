package com.kollect.tests.data;

import java.util.Map;

import org.junit.Assert;
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
    Long expectedResult = 300000l;
    @SuppressWarnings("unchecked")
    Map<String, Long> map = (Map<String, Long>) service.executeQuery("getInvoiceCount", null).get(0);
    Long actualResult = map.get("count");
    Assert.assertEquals("Expected and actual are not same", expectedResult, actualResult);

  }

    void taxAmountShouldBeEqualToExpected(){
    Double expectedResult = 0.00;

    //when .....




    }

    void invoiceAmountShouldBeEqualToExpected(){

    }

    void invoiceDueDateShouldBeEqualToExpected(){

    }


  void invoiceDateShouldBeEqualToExpected(){

  }

}
