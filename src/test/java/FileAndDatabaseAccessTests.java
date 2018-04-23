import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import CsvToDatabase.ConnectionUtilities.DatabaseConnection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class FileAndDatabaseAccessTests
{

	@Test
	@Disabled("Only run this if access to the DB is failing")
	void testHikariDatabaseAccessThroughJDBC()
	{
		var databaseConnection =  DatabaseConnection.getConnection();
		assertNotNull(databaseConnection);
	}

	@Test
	@Disabled("Only run this if access to the DB is failing")
	void testPGDatabaseAccessThroughJDBC()
	{
		var databaseConnection =  DatabaseConnection.getConnection();
		assertNotNull(databaseConnection);
	}

	@Test
	@Disabled("Only run this if access to the DB is failing")
	void testThrowExceptionOnInvalidDataSourceArgument()
	{
		var datasourceName = "garbage";
		Throwable exception = assertThrows(RuntimeException.class,() -> DatabaseConnection.getConnection());
		assertEquals("Can't find datasource implementation for " + datasourceName,exception.getMessage(),"An exception should be thrown that terminates the program for an invalid datasource implementation");
	}

	@ParameterizedTest
	@ValueSource(strings = { "Organization",
							 "Service",
							 "Program",
							 "Location",
							 "Service_At_Location",
							 "physical_address" })
	void testForPresenceOfCsvFiles(String string)
			throws IOException
	{
		var linesFromReadFiles = Files.readAllLines(
				Paths.get(System.getProperty("user.home"), "/Downloads", string + ".csv"));
		assertNotNull(linesFromReadFiles);
	}
	
}
