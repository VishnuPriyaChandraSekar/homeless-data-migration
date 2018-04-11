package CsvToDatabase.CSVUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import CsvToDatabase.DataModels.Location;
import CsvToDatabase.DataModels.Organization;
import CsvToDatabase.DataModels.Program;
import CsvToDatabase.DataModels.Service;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ReadFromCSV
{

	public static void readIntoOrganization(List<Organization> organization)
	{
		try
		{
			var records = CSVFormat.EXCEL
								  .withFirstRecordAsHeader()
								  .parse(Files.newBufferedReader(Paths.get("/Users/adityas/Downloads/Organization.csv")));
			var i = 0;
			for (CSVRecord record : records)
			{
				organization.add(i, new Organization());
				organization.get(i).id = record.get(0);
				organization.get(i).name = record.get(1);
				organization.get(i).alternate_name = record.get(2);
				if (record.get(3)
						  .equals(""))
				{
					organization.get(i).description = "Sample Description Must Be Filled!";
				}
				else
				{
					organization.get(i).description = record.get(3);

				}
				organization.get(i).email = record.get(4);
				organization.get(i).url = record.get(5);
				organization.get(i).tax_status = record.get(6);
				organization.get(i).tax_id = record.get(7);
				organization.get(i).year_incorporated = record.get(8)
															  .equals("") ? 0 : Integer.parseInt(record.get(8));
				organization.get(i).legal_status = record.get(9);
				i++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void readIntoServices(List<Service> services)
	{
		try
		{
			var records = CSVFormat.EXCEL
								  .withFirstRecordAsHeader()
								  .parse(Files.newBufferedReader(Paths.get("/Users/adityas/Downloads/Services.csv")));
			var i = 0;
			for (CSVRecord record : records)
			{
				services.add(i, new Service());
				services.get(i).id = record.get(0);
				services.get(i).organization_id = record.get("organization_id");
				services.get(i).program_id = record.get("program_id");
				services.get(i).name = record.get("name");
				services.get(i).alternate_name = record.get("alternate_name");
				services.get(i).description = record.get("description");
				services.get(i).email = record.get("email");
				services.get(i).url = record.get("url");
				services.get(i).status = record.get("status");
				if (services.get(i).status.isEmpty())
				{
					services.get(i).status = "STATUS UNKNOWN";
				}
				services.get(i).interpretation_services = record.get("interpretation_services");
				services.get(i).application_process = record.get("application_process");
				services.get(i).wait_time = record.get("wait_time");
				services.get(i).fees = record.get("fees");
				services.get(i).accreditation = record.get("accreditations");
				services.get(i).licenses = record.get("licenses");
				i++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void readIntoLocation(List<Location> locations)
	{
		try
		{
			var records = CSVFormat.EXCEL
								  .withFirstRecordAsHeader()
								  .parse(Files.newBufferedReader(Paths.get("/Users/adityas/Downloads/Location.csv")));
			var i = 0;
			for (CSVRecord record : records)
			{
				locations.add(i, new Location());
				locations.get(i).id = record.get(0);
				locations.get(i).organization_id = record.get("organization_id");
				locations.get(i).name = record.get("name");
				locations.get(i).alternate_name = record.get("alternate_name");
				locations.get(i).description = record.get("description");
				locations.get(i).transportation = record.get("transportation");
				locations.get(i).latitude = Double.parseDouble(record.get("latitude"));
				locations.get(i).longitude = Double.parseDouble(record.get("longitude"));
				i++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void readIntoPrograms(List<Program> programs)
	{
		try
		{
			var records = CSVFormat.EXCEL
								  .withFirstRecordAsHeader()
								  .parse(Files.newBufferedReader(Paths.get("/Users/adityas/Downloads/Program.csv")));
			var i = 0;
			for (CSVRecord record : records)
			{
				programs.add(i, new Program());
				programs.get(i).id = record.get("﻿id");
				programs.get(i).organization_id = record.get("organization_id");
				programs.get(i).name = record.get("name");
				programs.get(i).alternate_name = record.get("alternate_name");
				programs.get(i).description = record.get("description");
				programs.get(i).url = record.get("url");
				i++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
