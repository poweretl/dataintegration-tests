package com.powerapps.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDataAccessProvider {

	List<Object> selectQuery(String queryName, Object object);
	<T> List<T> query(String queryName, Object object) throws SQLException, IOException;
}
