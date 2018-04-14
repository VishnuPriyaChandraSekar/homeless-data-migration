import java.sql.Connection;
import java.sql.SQLException;

import CsvToDatabase.DBUpdates.Update;
import CsvToDatabase.DBUpdates.Utilities.DBUtils;
import CsvToDatabase.DataModels.ServiceAtLocation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DatabasePopulationTests
{

	private static Connection databaseConnection;

	@BeforeAll
	static void setupJdbc()
	{
		databaseConnection = DBUtils.getConnection();
	}

	@Test
	void testAbilityToPopulateDataToServiceAtLocationTable()
			throws SQLException
	{
//		ClearOutData.clearOutServiceAtLocation();
		Update.updateServiceAtLocation();
//		var resultSet = databaseConnection.createStatement().executeQuery("SELECT id from service_at_location");
//		resultSet.next();
//		assertEquals(36, resultSet.getString(1)
//								  .length(), "ID Must be a 36 character GUID");
	}

	@Test
	void testAbilityToDeleteTestDataToServiceAtLocationTable()
			throws SQLException
	{
		var serviceAtLocation = new ServiceAtLocation();
		serviceAtLocation.id = "0926EC41-A367-05E7-4A5B-D22E01F8A7A0";


		var statement = databaseConnection.prepareStatement("DELETE FROM service_at_location WHERE service_at_location.id=?");
		statement.setString(1, serviceAtLocation.id);
		statement.executeUpdate();

	}

	//	@AfterAll
	static void closeJDbc()
			throws SQLException
	{
		databaseConnection.close();
	}
}
