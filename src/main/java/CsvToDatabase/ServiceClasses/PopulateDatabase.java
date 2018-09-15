package CsvToDatabase.ServiceClasses;

import CsvToDatabase.ConnectionUtilities.DatabaseConnection;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

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
		updateContact();
		updateLanguage();
		updateProgramServiceTaxonomy();
		updateServiceArea();
		updateTaxonomy();
	}

	public static long updateOrganization()
	{

		var tableAndFilename = "organization";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updateServices()
	{

		var tableAndFilename = "service";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updateProgram()
	{

		var tableAndFilename = "program";
		return pgCopyQuery(tableAndFilename);
	}


	public static long updateLocation()
	{
		var tableAndFilename = "location";
		return pgCopyQuery(tableAndFilename);
	}

	public static long updateServiceAtLocation()
	{
		var tableAndFilename = "service_at_location";
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
	
	private static long updateContact()
	{
		var tableAndFilename = "contact";
		return pgCopyQuery(tableAndFilename);
	}

	private static long updateLanguage()
	{
		var tableAndFilename = "language";
		return pgCopyQuery(tableAndFilename);
	}

	private static long updateProgramServiceTaxonomy()
	{
		var tableAndFilename = "program_service_taxonomy";
		return pgCopyQuery(tableAndFilename);
	}

	private static long updateServiceArea()
	{
		var tableAndFilename = "service_area";
		return pgCopyQuery(tableAndFilename);
	}

	private static long updateTaxonomy()
	{
		var tableAndFilename = "taxonomy";
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
