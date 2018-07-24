package com.powerapps.test.query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.powerapps.util.DataAccessProvider;
import com.powerapps.util.IDataAccessProvider;
import com.powerapps.util.IbatisClient;

public class AgencyWorklistManagementLiteTest {
public IDataAccessProvider provider;

public AgencyWorklistManagementLiteTest() {
	this.provider = new DataAccessProvider(new IbatisClient());
}


@Test
public void check_work_list_lite_query_syntax_validity() throws SQLException, IOException {
	provider.query("getWlmWorkListLite", null);
}

@Test
public void work_list_lite_query_return_at_least_one_record() throws SQLException, IOException {
	List<Object> resultList = provider.query("getWlmWorkListLite", 1);
	//System.out.println(resultList.size());
	Assert.assertNotEquals(0, resultList.size());
}
}
