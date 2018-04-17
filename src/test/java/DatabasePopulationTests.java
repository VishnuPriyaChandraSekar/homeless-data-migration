import java.sql.Connection;
import java.sql.SQLException;

import CsvToDatabase.DBUpdates.Update;
import CsvToDatabase.DBUpdates.Utilities.DBUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabasePopulationTests
{

	private static Connection databaseConnection;

	@BeforeAll
	static void setupJdbc()
	{
		databaseConnection = DBUtils.getConnection();
	}

	@Test
	void testAbilityToPopulateDataToOrganizationTable()
			throws SQLException
	{
		long numberOfLinesCopied = Update.pgCopyQuery("Organization");
		System.out.println(numberOfLinesCopied + " lines copied");
		assertTrue(numberOfLinesCopied > 0,"More than one line should be copied");
	}
	
	@Test
	void testAbilityToPopulateDataToServiceAtLocationTable()
			throws SQLException
	{
		long numberOfLinesCopied = Update.updateServiceAtLocation();
		assertTrue(numberOfLinesCopied > 0,"More than one line should be copied");
	}
	

	@AfterAll
	static void closeJDbc()
			throws SQLException
	{
		databaseConnection.close();
	}
}
