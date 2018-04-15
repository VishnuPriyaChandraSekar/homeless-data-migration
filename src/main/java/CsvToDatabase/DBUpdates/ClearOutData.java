package CsvToDatabase.DBUpdates;

import java.sql.Connection;

import CsvToDatabase.DBUpdates.Utilities.DBUtils;

public class ClearOutData
{

	public static void clearOutAllTables()
	{

		clearOutOrganization();
		clearOutProgram();
		clearOutLocation();
		clearOutService();
		clearOutServiceAtLocation();
	}

	public static void clearOutOrganization()
	{
		var tableName = "organization";
		pgTruncateQuery(tableName);
	}

	public static void clearOutProgram()
	{
		var tableName = "program";
		pgTruncateQuery(tableName);
	}

	public static void clearOutService()
	{
		var tableName = "service";
		pgTruncateQuery(tableName);
	}

	public static void clearOutLocation()
	{
		var tableName = "location";
		pgTruncateQuery(tableName);
	}

	public static void clearOutServiceAtLocation()
	{
		var tableName = "service_at_location";
		pgTruncateQuery(tableName);
	}

	private static void pgTruncateQuery(String tableName)
	{
		long startTime = System.currentTimeMillis();

		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE " + tableName + " CASCADE");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
