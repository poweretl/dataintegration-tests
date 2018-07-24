package com.kollect.tests.data;

import com.kollect.etl.dataaccess.AbstractSqlSessionProvider;
import com.kollect.tests.common.DaoProvider;
import com.kollect.tests.common.ReadWriteServiceProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;


public class PaymentTest {

    private ReadWriteServiceProvider service;


   // @Before
    public void runBeforeEachTest() {
        service = new ReadWriteServiceProvider(new DaoProvider(new AbstractSqlSessionProvider("mahb_prod")));
    }



    /*@Test
    public void shouldNotHaveDuplicates(){
        Long expectedCount = 0L;
        Long actualResult = 0L;

       *//* if (service.executeQuery("getPaymentUnique", null).size() > 0){
            Map<String, Long> m = (Map) service.executeQuery("getPaymentUnique", null);
            actualResult = m.get("count");
        }
        Assert.assertEquals(expectedCount, actualResult);*//*
    }
*/
  //  @Test
    public void shouldHaveExactQuantityOfPayment() {
        Long expectedResult = 3618941L;

        Map<String, Long> map = (Map<String, Long>) service.executeQuery("getPaymentCount", null).get(0);
        Long actualResult = map.get("count");
        Assert.assertEquals("Expected and actual are not same", expectedResult, actualResult);
    }

   // @Test
    public void shouldBeTraceableToSourceHash(){
        Long expectedResult = 1L;
        String source_hash = "4ea4d690a67b992339a871b1e127fbf107c14ce96e1dbd181051d37ddc8bd905";
        Map<String, Long> map = (Map<String, Long>) service.executeQuery("shouldBeTraceableToSourceHash", source_hash).get(0);
        Long actualResult = map.get("count");
        Assert.assertEquals("Expected and actual are not same", expectedResult, actualResult);
    }
}
