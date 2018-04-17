package CsvToDatabase;

import CsvToDatabase.DBUpdates.ClearOutData;
import CsvToDatabase.DBUpdates.Update;

public class MainClass
{

	public static void main(String[] args)
	{
		

		//Truncate tables
		ClearOutData.clearOutAllTables();
		Update.updateAll();
		
		
	}
}
