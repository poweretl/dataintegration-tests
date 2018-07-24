package com.powerapps.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataAccessProvider implements IDataAccessProvider {
	public final IbatisClient ibatisClient;
	private static final Logger LOG = LoggerFactory.getLogger(DataAccessProvider.class);

	public DataAccessProvider(IbatisClient ibatisClient) {
		this.ibatisClient = ibatisClient;
	}

	public List<Object> selectQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> query(String queryName, Object object) throws SQLException, IOException {

		long queryStart = System.currentTimeMillis();
		List<Object> result = ibatisClient.getSqlMapClient().queryForList(queryName, object);
		long queryEnd = System.currentTimeMillis();
		logQueryStatistics("NONE", queryName, queryStart, queryEnd);

		return result;
	}

	private void logQueryStatistics(String strategy, String queryName, long queryStart, long queryEnd) {
		Logger log = getLog();
		log.info("Query {} {} ms using {} ({})",
				new Object[] { queryName, (queryEnd - queryStart), strategy, Thread.currentThread().getName() });
	}

	private Logger getLog() {
		return LOG;
	}

}
