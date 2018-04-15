package CsvToDatabase;

import CsvToDatabase.DBUpdates.ClearOutData;
import CsvToDatabase.DBUpdates.Update;

public class MainClass
{

	public static void main(String[] args)
	{
		

		//Truncate tables
//		ClearOutData.clearOutAllTables();
		
		ClearOutData.clearOutLocation();
		ClearOutData.clearOutServiceAtLocation();
		Update.updateLocation();

//		ReadFromCSV.readIntoServiceAtLocation(serviceAtLocations);
		Update.updateServiceAtLocation();
		
		
	}
}
