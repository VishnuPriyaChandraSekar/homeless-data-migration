package CsvToDatabase.DBUpdates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import CsvToDatabase.CSVUtils.ReadFromCSV;
import CsvToDatabase.DBUpdates.Utilities.DBUtils;
import CsvToDatabase.DataModels.Location;
import CsvToDatabase.DataModels.Organization;
import CsvToDatabase.DataModels.Program;
import CsvToDatabase.DataModels.Service;

public class Update
{

	public static void updateOrganization()
	{
		var organization = new ArrayList<Organization>();
		ReadFromCSV.readIntoOrganization(organization);
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.setAutoCommit(false);
			connection.createStatement()
					  .executeUpdate("DELETE FROM organization");
			var query = "INSERT INTO " + Organization.class.getSimpleName() + " VALUES (?,?,?,?,?,?,?,?,?,?)";
			var statement = connection.prepareStatement(query);
			organization.forEach(o -> {
				try
				{
					setStringOrNull(statement, 1, o.id);
					setStringOrNull(statement, 1, o.id);
					setStringOrNull(statement, 2, o.name);
					setStringOrNull(statement, 3, o.alternate_name);
					setStringOrNull(statement, 4, o.description);
					setStringOrNull(statement, 5, o.email);
					setStringOrNull(statement, 6, o.url);
					setStringOrNull(statement, 7, o.tax_status);
					setStringOrNull(statement, 8, o.tax_id);
					setIntOrNull(statement, 9, o.year_incorporated);
					setStringOrNull(statement, 10, o.legal_status);
					statement.addBatch();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}

			});
			statement.executeBatch();
			connection.commit();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	private static void setIntOrNull(PreparedStatement statement,
									 int i,
									 String stringInteger)
			throws SQLException
	{
		if (stringInteger.isEmpty())
		{
			statement.setNull(i, Types.INTEGER);
		}
		else
		{
			statement.setInt(i, Integer.parseInt(stringInteger));
		}
	}

	private static void setStringOrNull(PreparedStatement statement,
										int i,
										String string)
			throws SQLException
	{
		if (string.equals(""))
		{
			statement.setNull(i, Types.VARCHAR);
		}
		else
		{
			statement.setString(i, string);
		}
	}

	public static void updateServices()
	{
		var service = new ArrayList<Service>();
		ReadFromCSV.readIntoServices(service);
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.setAutoCommit(false);
			connection.createStatement()
					  .executeUpdate("DELETE FROM service");
			var query = "INSERT INTO service VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			var statement = connection.prepareStatement(query);
			service.forEach(services -> {
				try
				{
					setStringOrNull(statement, 1, services.id);
					setStringOrNull(statement, 2, services.organization_id);
					setStringOrNull(statement, 3, services.program_id);
					setStringOrNull(statement, 4, services.name);
					setStringOrNull(statement, 5, services.alternate_name);
					setStringOrNull(statement, 6, services.description);
					setStringOrNull(statement, 7, services.url);
					setStringOrNull(statement, 8, services.email);
					setStringOrNull(statement, 9, services.status);
					setStringOrNull(statement, 10, services.interpretation_services);
					setStringOrNull(statement, 11, services.application_process);
					setStringOrNull(statement, 12, services.wait_time);
					setStringOrNull(statement, 13, services.fees);
					setStringOrNull(statement, 14, services.accreditation);
					setStringOrNull(statement, 15, services.licenses);
					statement.addBatch();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}

			});
			statement.executeBatch();
			connection.commit();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	public static void updateProgram()
	{
		var programs = new ArrayList<Program>();
		ReadFromCSV.readIntoPrograms(programs);
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.setAutoCommit(false);
			connection.createStatement()
					  .executeUpdate("DELETE FROM program");
			var query = "INSERT INTO program VALUES (?,?,?,?,?,?)";
			var statement = connection.prepareStatement(query);
			programs.forEach(program -> {
				try
				{
					setStringOrNull(statement, 1, program.id);
					setStringOrNull(statement, 2, program.organization_id);
					setStringOrNull(statement, 3, program.name);
					setStringOrNull(statement, 4, program.alternate_name);
					setStringOrNull(statement, 5, program.description);
					setStringOrNull(statement, 6, program.url);
					statement.addBatch();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}

			});
			statement.executeBatch();
			connection.commit();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	public static void updateLocation()
	{
		var locations = new ArrayList<Location>();
		ReadFromCSV.readIntoLocation(locations);
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.setAutoCommit(false);
			connection.createStatement()
					  .executeUpdate("DELETE FROM location");
			var query = "INSERT INTO location VALUES (?,?,?,?,?,?,?,?)";
			var statement = connection.prepareStatement(query);
			locations.forEach(location -> {
				try
				{
					setStringOrNull(statement, 1, location.id);
					setStringOrNull(statement, 2, location.organization_id);
					setStringOrNull(statement, 3, location.name);
					setStringOrNull(statement, 4, location.alternate_name);
					setStringOrNull(statement, 5, location.description);
					setStringOrNull(statement, 6, location.transportation);
					statement.setDouble(7, location.latitude);
					statement.setDouble(8, location.longitude);
					statement.addBatch();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}

			});
			statement.executeBatch();
			connection.commit();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
