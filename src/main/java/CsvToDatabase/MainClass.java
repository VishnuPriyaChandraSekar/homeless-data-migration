package CsvToDatabase;

import CsvToDatabase.service.ClearOutData;
import CsvToDatabase.service.PopulateDatabase;

public class MainClass
{

	public static void main(String[] args)
	{
		
		ClearOutData.clearOutAllTables();
		PopulateDatabase.updateAll();
		
	}
}
