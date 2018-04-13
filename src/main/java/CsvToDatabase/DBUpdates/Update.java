package CsvToDatabase.DBUpdates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import CsvToDatabase.DBUpdates.Utilities.DBUtils;
import CsvToDatabase.DataModels.*;

public class Update
{

	public static void updateOrganization(List<Organization> organizations)
	{
		
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE organization CASCADE");
			var query = "INSERT INTO " + Organization.class.getSimpleName() + " VALUES (?,?,?,?,?,?,?,?,?,?)";
			var statement = connection.prepareStatement(query);
			organizations.forEach(o -> {
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

	public static void updateServices(List<Service> services)
	{
		
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE service CASCADE");
			var query = "INSERT INTO service VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			var statement = connection.prepareStatement(query);
			services.forEach(service -> {
				try
				{
					setStringOrNull(statement, 1, service.id);
					setStringOrNull(statement, 2, service.organization_id);
					setStringOrNull(statement, 3, service.program_id);
					setStringOrNull(statement, 4, service.name);
					setStringOrNull(statement, 5, service.alternate_name);
					setStringOrNull(statement, 6, service.description);
					setStringOrNull(statement, 7, service.url);
					setStringOrNull(statement, 8, service.email);
					setStringOrNull(statement, 9, service.status);
					setStringOrNull(statement, 10, service.interpretation_services);
					setStringOrNull(statement, 11, service.application_process);
					setStringOrNull(statement, 12, service.wait_time);
					setStringOrNull(statement, 13, service.fees);
					setStringOrNull(statement, 14, service.accreditation);
					setStringOrNull(statement, 15, service.licenses);
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

	public static void updateProgram(List<Program> programs)
	{
		
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE program CASCADE");
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

	public static void updateLocation(List<Location> locations)
	{
		
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE location CASCADE");
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

	public static void updateServiceAtLocation(List<ServiceAtLocation> serviceAtLocations)
	{
		long startTime = System.currentTimeMillis();
		try (Connection connection = DBUtils.getConnection())
		{
			connection.createStatement()
					  .executeUpdate("TRUNCATE TABLE service_at_location CASCADE");
			var query = "INSERT INTO service_at_location VALUES (?,?,?,?)";
			var statement = connection.prepareStatement(query);
			serviceAtLocations.forEach(serviceAtLocation -> {
				try
				{
					setStringOrNull(statement, 1, serviceAtLocation.id);
					setStringOrNull(statement, 2, serviceAtLocation.service_id);
					setStringOrNull(statement, 3, serviceAtLocation.location_id);
					setStringOrNull(statement, 4, serviceAtLocation.description);
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
