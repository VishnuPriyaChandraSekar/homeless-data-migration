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

	private static final String dataSourceToUse;
	private static final Properties properties = new Properties();

	static
	{
		try
		{
			properties.load(Files.newInputStream(Paths.get("src/main/resources/Datasource.properties")));
			dataSourceToUse = properties.getProperty("dataSourceToUse");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static Connection getConnection()
	{
		switch (dataSourceToUse.toLowerCase())
		{
			case "hikari":
				return getHikariConnection();
			case "postgres":
				return getPGConnection();
			default:
				throw new RuntimeException("Can't find datasource implementation for " + dataSourceToUse);
		}
	}

	private static Connection getHikariConnection()
	{
		properties.remove("dataSourceToUse");
		HikariConfig config = new HikariConfig(properties);
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
