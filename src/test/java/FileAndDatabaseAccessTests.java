import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import CsvToDatabase.ConnectionUtilities.DatabaseConnection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileAndDatabaseAccessTests
{

	@Test
	@Disabled("Only run this if access to the DB is failing")
	void testForDatabaseAccessThroughJDBC()
	{
		var databaseConnection =  DatabaseConnection.getConnection("Hikari");
		assertNotNull(databaseConnection);

	}

	@ParameterizedTest
	@ValueSource(strings = { "Organization",
							 "Service",
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
