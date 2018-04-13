package CsvToDatabase.DBUpdates.Utilities;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtils
{

	public static Connection getConnection()
			throws SQLException
	{
		HikariConfig config = new HikariConfig("src/main/resources/Datasource.properties");
		config.setAutoCommit(false);
		HikariDataSource ds = new HikariDataSource(config);
		return ds.getConnection();
	}

	
}
