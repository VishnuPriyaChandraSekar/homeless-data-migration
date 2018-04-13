import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		databaseConnection = FileAndDatabaseAccessTests.getJDBCAccess();
	}

	@Test
	void truncateDataFromServiceAtLocation()
			throws SQLException
	{
		databaseConnection.createStatement()
				  .executeUpdate("TRUNCATE TABLE service_at_location CASCADE");
		var statement = databaseConnection.prepareStatement("SELECT * FROM service_at_location");
		ResultSet resultSet = statement.executeQuery();
		assertFalse(resultSet.next());
	}
	@AfterAll
	static void closeJDbc()
			throws SQLException
	{
		databaseConnection.close();
	}

}
