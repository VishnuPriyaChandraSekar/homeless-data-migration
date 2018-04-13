import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

import CsvToDatabase.DataModels.ServiceAtLocation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

class DatabasePopulationTests
{

	private static Connection databaseConnection;

	@BeforeAll
	static void setupJdbc()
	{
	databaseConnection = FileAndDatabaseAccessTests.getJDBCAccess();
	}

	@Test
	void testForAbilityToPopulateTestDataToServiceAtLocationTable()
			throws SQLException, IOException
	{

		long startTime = System.currentTimeMillis();
		CopyManager copyManager = new CopyManager((BaseConnection) databaseConnection);
		var sqlQuery = "COPY service_at_location FROM stdin WITH CSV HEADER";
		long rowsAffected = copyManager.copyIn(sqlQuery, Files.newBufferedReader(Paths.get("/Users/adityas/Downloads/Service At Location.csv")));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		System.out.println(rowsAffected);
		
	}

	@Test
	void testForAbilityToDeleteTestDataToServiceAtLocationTable()
			throws SQLException
	{
		var serviceAtLocation = new ServiceAtLocation();
		serviceAtLocation.id = "0926EC41-A367-05E7-4A5B-D22E01F8A7A0";


		var statement = databaseConnection.prepareStatement("DELETE FROM service_at_location WHERE service_at_location.id=?");
		statement.setString(1, serviceAtLocation.id);
		statement.executeUpdate();

	}

	@AfterAll
	static void closeJDbc()
			throws SQLException
	{
		databaseConnection.close();
	}
}
