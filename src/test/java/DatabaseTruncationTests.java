import java.sql.Connection;
import java.sql.SQLException;

import CsvToDatabase.DBUpdates.ClearOutData;
import CsvToDatabase.DBUpdates.Utilities.DBUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
//		databaseConnection.createStatement()
//				  .executeUpdate("TRUNCATE TABLE service_at_location CASCADE");
		ClearOutData.clearOutServiceAtLocation();
		databaseConnection.createStatement().executeQuery("SELECT * FROM service_at_location");
	}
	@AfterAll
	static void closeJDbc()
			throws SQLException
	{
		databaseConnection.close();
	}

}
