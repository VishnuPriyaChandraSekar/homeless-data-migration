package CsvToDatabase.DBUpdates.Utilities;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtils
{

	public static Connection getConnection()
			
	{
		HikariConfig config = new HikariConfig("src/main/resources/Datasource.properties");
		config.setAutoCommit(true);
		HikariDataSource ds = new HikariDataSource(config);
		try
		{
			return ds.getConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	
}
