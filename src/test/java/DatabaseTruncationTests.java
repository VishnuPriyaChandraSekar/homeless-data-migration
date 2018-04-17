import java.sql.Connection;
import java.sql.SQLException;

import CsvToDatabase.DBUpdates.ClearOutData;
import CsvToDatabase.DBUpdates.Utilities.DBUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DatabaseTruncationTests
{
	private static Connection databaseConnection;

	@BeforeAll
	static void setupJdbc()
	{
		databaseConnection = DBUtils.getConnection();
	}

	@Test
	void truncateDataFromServiceAtLocation()
			throws SQLException
	{
		ClearOutData.clearOutServiceAtLocation();
		var resultSet = databaseConnection.createStatement()
						  .executeQuery("SELECT id FROM service_at_location");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");
		
	}

	@Test
	void truncateDataFromOrganization()
			throws SQLException
	{
		ClearOutData.clearOutOrganization();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT id FROM organization");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");

	}
	
	@AfterAll
	static void closeJDbc()
			throws SQLException
	{
		databaseConnection.close();
	}

}
