import java.sql.Connection;
import java.sql.SQLException;

import CsvToDatabase.ConnectionUtilities.DatabaseConnection;
import CsvToDatabase.ServiceClasses.ClearOutData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DatabaseEmptyingTests
{
	private static Connection databaseConnection;

	@BeforeAll
	static void setupJdbc()
	{
		databaseConnection = DatabaseConnection.getConnection();
	}

	@Test
	void emptyDataFromOrganization()
			throws SQLException
	{
		ClearOutData.clearOutOrganization();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT id FROM organization");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");

	}

	@Test
	void emptyDataFromProgram()
			throws SQLException
	{
		ClearOutData.clearOutProgram();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT id FROM program");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");

	}

	@Test
	void emptyDataFromLocation()
			throws SQLException
	{
		ClearOutData.clearOutLocation();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT id FROM location");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");

	}

	@Test
	void emptyDataFromService()
			throws SQLException
	{
		ClearOutData.clearOutService();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT id FROM service");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");

	}

	@Test
	void emptyDataFromServiceAtLocation()
			throws SQLException
	{
		ClearOutData.clearOutServiceAtLocation();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT id FROM service_at_location");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");

	}

	@Test
	void emptyDataFromPhysicalAddress()
			throws SQLException
	{
		ClearOutData.clearOutPhysicalAddress();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT id FROM physical_address");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");

	}

	@Test
	void emptyDataFromPhone()
			throws SQLException
	{
		ClearOutData.clearOutPhone();
		var resultSet = databaseConnection.createStatement()
										  .executeQuery("SELECT id FROM phone");
		assertFalse(resultSet.next(),"There should be no next row in the ResultSet.");

	}
	
	@AfterAll
	static void closeJDbc()
			throws SQLException
	{
		databaseConnection.close();
	}

}
