import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
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

		getJDBCAccess();
		assertNotNull(databaseConnection);

	}

	@BeforeAll
	private static void getJDBCAccess()
	{
		URI dbUri = null;
		try
		{
			dbUri = new URI(System.getenv("DATABSE_URL"));
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
		String username = dbUri.getUserInfo()
							   .split(":")[0];
		String password = dbUri.getUserInfo()
							   .split(":")[1];
		String dbUrl =
				"jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?" + username +
				password;

		var dataSource = new PGSimpleDataSource();
		dataSource.setUrl(dbUrl);

		try
		{
			databaseConnection = dataSource.getConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
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
