package CsvToDatabase.ServiceClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import CsvToDatabase.ConnectionUtilities.DatabaseConnection;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class PopulateDatabase
{



	public static void updateAll()
	{
		updateOrganization();
		updateProgram();
		updateServices();
		updateLocation();
		updateServiceAtLocation();
		updatePhysicalAddress();
		updatePhone();
		updateRegularSchedule();
		updateHolidaySchedule();
		updateAccessibilityForDisabilities();
		updateLgbtqFriendlyServices();
		updateAgeEligibility();
		updateGenderEligibility();
	}

	public static long updateOrganization()
	{

		var tableAndFilename = "Organization";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updateServices()
	{

		var tableAndFilename = "Service";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updateProgram()
	{

		var tableAndFilename = "Program";
		return pgCopyQuery(tableAndFilename);
	}


	public static long updateLocation()
	{
		var tableAndFilename = "Location";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updateServiceAtLocation()
	{
		var tableAndFilename = "Service_At_Location";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updatePhysicalAddress()
	{
		var tableAndFilename = "physical_address";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updatePhone()
	{
		var tableAndFilename = "phone";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updateRegularSchedule()
	{
		var tableAndFilename = "regular_schedule";
		return pgCopyQuery(tableAndFilename);
	}

	private static long updateHolidaySchedule()
	{
		var tableAndFilename = "holiday_schedule";
		return pgCopyQuery(tableAndFilename);
	}

	private static long updateAccessibilityForDisabilities()
	{
		var tableAndFilename = "accessibility_for_disabilities";
		return pgCopyQuery(tableAndFilename);
	}

	private static long updateLgbtqFriendlyServices()
	{
		var tableAndFilename = "lgbtq_friendly_services";
		return pgCopyQuery(tableAndFilename);
	}
	
	private static long updateAgeEligibility()
	{
		var tableAndFilename = "age_eligibility";
		return pgCopyQuery(tableAndFilename);

	}

	private static long updateGenderEligibility()
	{
		var tableAndFilename = "gender_eligibility";
		return pgCopyQuery(tableAndFilename);

	}
	
	private static long pgCopyQuery(String tableAndFilename)
	{
		var startTime = System.currentTimeMillis();
		var sqlQuery = "COPY " + tableAndFilename.toLowerCase() + "  FROM stdin WITH CSV HEADER";
		var linesCopied = 0L;
		try (var connection = DatabaseConnection.getConnection())
		{
			var baseConnection = connection.unwrap(BaseConnection.class);
			var copyManager = new CopyManager(baseConnection);
			linesCopied = copyManager.copyIn(sqlQuery, Files.newBufferedReader(
					Paths.get("/Users/adityas/Downloads/", tableAndFilename + ".csv")));
		}
		catch (SQLException | IOException e)
		{
			e.printStackTrace();
		}

		var endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		return linesCopied;
	}
}
