package CsvToDatabase.DataModels;

public class Program
{

	public String id;
	public String organization_id;
	public String name;
	public String alternate_name;
	public String description;
	public String url;

	@Override
	public String toString()
	{
		return "Program{" +
			   "id='" + id + '\'' +
			   ", organization_id='" + organization_id + '\'' +
			   ", name='" + name + '\'' +
			   ", alternate_name='" + alternate_name + '\'' +
			   ", description='" + description + '\'' +
			   ", url='" + url + '\'' +
			   '}';
	}
}
