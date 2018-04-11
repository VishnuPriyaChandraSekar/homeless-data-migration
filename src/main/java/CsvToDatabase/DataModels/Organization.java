package CsvToDatabase.DataModels;

public class Organization
{
public String id;
public String name;
public String alternate_name;
public String description;
public String email;
public String url;
public String tax_status;
public String tax_id;
public int year_incorporated;
public String legal_status;

	@Override
	public String toString()
	{
		return "Organization{" +
			   "id='" + id + '\'' +
			   ", name='" + name + '\'' +
			   ", alternate_name='" + alternate_name + '\'' +
			   ", description='" + description + '\'' +
			   ", email='" + email + '\'' +
			   ", url='" + url + '\'' +
			   ", tax_status='" + tax_status + '\'' +
			   ", tax_id='" + tax_id + '\'' +
			   ", year_incorporated=" + year_incorporated +
			   ", legal_status='" + legal_status + '\'' +
			   '}';
	}
}
