package CsvToDatabase;

import java.util.ArrayList;

import CsvToDatabase.CSVUtils.ReadFromCSV;
import CsvToDatabase.DBUpdates.TruncateData;
import CsvToDatabase.DBUpdates.Update;
import CsvToDatabase.DataModels.*;

public class MainClass
{

	public static void main(String[] args)
	{
		// Initialize variables
		var serviceAtLocations = new ArrayList<ServiceAtLocation>();
		var organizations = new ArrayList<Organization>();
		var locations = new ArrayList<Location>();
		var services = new ArrayList<Service>();
		var programs = new ArrayList<Program>();

		//Truncate tables
		TruncateData.truncateAll();
		
		//Update tables below
		ReadFromCSV.readIntoOrganization(organizations);
		Update.updateOrganization(organizations);

		ReadFromCSV.readIntoPrograms(programs);
		Update.updateProgram(programs);

		ReadFromCSV.readIntoServices(services);
		Update.updateServices(services);

		ReadFromCSV.readIntoLocation(locations);
		Update.updateLocation(locations);

		ReadFromCSV.readIntoServiceAtLocation(serviceAtLocations);
		Update.updateServiceAtLocation(serviceAtLocations);
		
		
	}
}
