package CsvToDatabase.ConnectionUtilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class DatabaseConnection
{

	public static Connection getConnection(String dataSourceToUse)
	{
		if (dataSourceToUse.equalsIgnoreCase("hikari"))
		{
			return getHikariConnection();
		}
		else
		{
			return getPGConnection();
		}
	}

	private static Connection getHikariConnection()
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

	private static Connection getPGConnection()
	{
		Properties properties = new Properties();
		try
		{
			properties.load(Files.newInputStream(Paths.get("src/main/resources/Datasource.properties")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		var dataSource = new PGSimpleDataSource();
		dataSource.setServerName(properties.getProperty("dataSource.serverName"));
		dataSource.setDatabaseName(properties.getProperty("dataSource.databaseName"));
		dataSource.setPortNumber(Integer.parseInt(properties.getProperty("dataSource.portNumber")));
		dataSource.setUser(properties.getProperty("dataSource.user"));
		dataSource.setPassword(properties.getProperty("dataSource.password"));
		try
		{
			return dataSource.getConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
