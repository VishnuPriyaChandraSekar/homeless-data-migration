package CsvToDatabase;

import CsvToDatabase.DBUpdates.ClearOutData;
import CsvToDatabase.DBUpdates.Update;

public class MainClass
{

	public static void main(String[] args)
	{
		

		//Truncate tables
//		ClearOutData.clearOutAllTables();
		
		//Update tables below
//		ReadFromCSV.readIntoOrganization(organizations);
//		Update.updateOrganization(organizations);
//
//		ReadFromCSV.readIntoPrograms(programs);
//		Update.updateProgram(programs);
//
//		ReadFromCSV.readIntoServices(services);
//		Update.updateServices(services);
//
//		ReadFromCSV.readIntoLocation(locations);
		ClearOutData.clearOutLocation();
		ClearOutData.clearOutServiceAtLocation();
		Update.updateLocation();

//		ReadFromCSV.readIntoServiceAtLocation(serviceAtLocations);
		Update.updateServiceAtLocation();
		
		
	}
}
