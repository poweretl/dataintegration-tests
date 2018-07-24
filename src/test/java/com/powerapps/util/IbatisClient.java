package com.powerapps.util;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IbatisClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(IbatisClient.class);

	public SqlMapClient getSqlMapClient() throws IOException {
		  Reader rd = Resources.getResourceAsReader("mbsb/server.xml");
	      SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
	  return smc;
	}
	
}
