package CsvToDatabase.DBUpdates.Utilities;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

public class DBUtils
{

	

	public static Connection getConnection()
			throws SQLException
	{
		var pgDataSource = new PGSimpleDataSource();
		pgDataSource.setDatabaseName("CodeForDC_Homeless");
		pgDataSource.setPortNumber(5432);
		pgDataSource.setPassword("");
		pgDataSource.setUser("postgres");
		return pgDataSource.getConnection();
	}

	
}
