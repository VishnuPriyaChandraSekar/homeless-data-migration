package CsvToDatabase.ServiceClasses;

import java.sql.Connection;

import CsvToDatabase.ConnectionUtilities.DatabaseConnection;

public class ClearOutData
{

	private static String dataSourceToUse;

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
		var tableName = "Organization";
		pgTruncateQuery(tableName);
	}

	public static void clearOutProgram()
	{
		var tableName = "Program";
		pgTruncateQuery(tableName);
	}

	public static void clearOutService()
	{
		var tableName = "Service";
		pgTruncateQuery(tableName);
	}

	public static void clearOutLocation()
	{
		var tableName = "Location";
		pgTruncateQuery(tableName);
	}

	public static void clearOutServiceAtLocation()
	{
		var tableName = "Service_at_Location";
		pgTruncateQuery(tableName);
	}

	public static void clearOutPhysicalAddress()
	{
		var tableName = "physical_address";
		pgTruncateQuery(tableName);
	}

	public static void clearOutPhone()
	{
		var tableName = "phone";
		pgTruncateQuery(tableName);
	}

	private static void pgTruncateQuery(String tableName)
	{
		long startTime = System.currentTimeMillis();

		try (Connection connection = DatabaseConnection.getConnection())
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
