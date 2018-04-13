package CsvToDatabase.DBUpdates;

import java.sql.Connection;

import CsvToDatabase.DBUpdates.Utilities.DBUtils;

public class TruncateData
{

	public static void truncateAll()
	{

		truncateOrganization();
		truncateProgram();
		truncateLocation();
		truncateService();
		truncateServiceAtLocation();
	}

	public static void truncateOrganization()
	{
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE organization CASCADE");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	public static void truncateProgram()
	{
		long startTime = System.currentTimeMillis();

		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE program CASCADE");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	public static void truncateService()
	{
		long startTime = System.currentTimeMillis();

		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE service CASCADE");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	public static void truncateLocation()
	{
		long startTime = System.currentTimeMillis();

		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE location CASCADE");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	public static void truncateServiceAtLocation()
	{
		long startTime = System.currentTimeMillis();

		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE service_at_location CASCADE");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
