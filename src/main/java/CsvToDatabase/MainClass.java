package CsvToDatabase;

import CsvToDatabase.DBUpdates.Update;

public class MainClass
{

	public static void main(String[] args)
	{
		Update.updateOrganization();
		Update.updateProgram();
		Update.updateServices();
		Update.updateLocation();
	}
}
