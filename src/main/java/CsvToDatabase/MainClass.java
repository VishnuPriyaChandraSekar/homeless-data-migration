package CsvToDatabase;

import CsvToDatabase.ServiceClasses.ClearOutData;
import CsvToDatabase.ServiceClasses.PopulateDatabase;

public class MainClass
{

	public static void main(String[] args)
	{
		
		ClearOutData.clearOutAllTables();
		PopulateDatabase.updateAll("hikari");
		
	}
}
