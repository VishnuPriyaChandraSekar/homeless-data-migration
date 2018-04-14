package CsvToDatabase.DBUpdates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import CsvToDatabase.DBUpdates.Utilities.DBUtils;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class Update
{

	public static void updateOrganization()
	{

		var tableAndFilename = "Organization";
		pgCopyQuery(tableAndFilename);
	}
	
	public static void updateServices()
	{

		var tableAndFilename = "Services";
		pgCopyQuery(tableAndFilename);
	}

	public static void updateProgram()
	{

		var tableAndFilename = "Program";
		pgCopyQuery(tableAndFilename);
	}
	

	public static void updateLocation()
	{
		var tableAndFilename = "Location";
		pgCopyQuery(tableAndFilename);
	}

	public static void updateServiceAtLocation()
	{
		var tableAndFilename = "Service_At_Location";
		pgCopyQuery(tableAndFilename);
	}
	
	private static void pgCopyQuery(String tableAndFilename)
	{
		var startTime = System.currentTimeMillis();
		var sqlQuery = "COPY " + tableAndFilename + " FROM stdin WITH CSV HEADER";
		try (var connection = DBUtils.getConnection())
		{
			var baseConnection = connection.unwrap(BaseConnection.class);
			var copyManager = new CopyManager(baseConnection);
			copyManager.copyIn(sqlQuery, Files.newBufferedReader(
					Paths.get("/Users/adityas/Downloads/",tableAndFilename + ".csv")));
		}
		catch (SQLException | IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Error copying data");
		}

		var endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
