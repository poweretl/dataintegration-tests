package com.powerapps.util;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;


public class IbatisClient {

	public SqlMapClient getSqlMapClient() throws IOException {
		  Reader rd = Resources.getResourceAsReader("mbsb/server.xml");
	      SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
	  return smc;
	}
	
}
