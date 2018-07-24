package com.powerapps.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDataAccessProvider {

	List<Object> selectQuery();
	List<Object> query(String queryName, Object object) throws SQLException, IOException;
}
