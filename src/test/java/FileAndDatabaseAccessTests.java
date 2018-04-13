import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.postgresql.ds.PGSimpleDataSource;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileAndDatabaseAccessTests
{
	private static Connection databaseConnection;

	@Test
	@Disabled("Only run this if access to the DB is failing")
	void testForDatabaseAccessThroughJDBC()
	{
		databaseConnection = getJDBCAccess();
		assertNotNull(databaseConnection);

	}

//	@BeforeAll
	static Connection getJDBCAccess()
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
		dataSource
				.setServerName(properties.getProperty("serverName"));
		dataSource.setDatabaseName(properties
										   .getProperty("databaseName"));
		dataSource.setPortNumber(Integer.parseInt(properties
														  .getProperty("portNumber")));
		dataSource.setUser(properties.getProperty("user"));
		dataSource.setPassword(properties.getProperty("password"));
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

	@ParameterizedTest
	@ValueSource(strings = { "Organization",
							 "Services",
							 "Program",
							 "Location" })
	void testForPresenceOfCsvFiles(String string)
			throws IOException
	{
		var linesFromReadFiles = Files.readAllLines(
				Paths.get(System.getProperty("user.home"), "/Downloads", string + ".csv"));
		assertNotNull(linesFromReadFiles);
	}
	
}
