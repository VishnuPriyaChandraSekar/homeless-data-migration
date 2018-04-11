import java.util.ArrayList;
import java.util.List;

import CsvToDatabase.CSVUtils.ReadFromCSV;
import CsvToDatabase.DataModels.Location;
import CsvToDatabase.DataModels.Organization;
import CsvToDatabase.DataModels.Program;
import CsvToDatabase.DataModels.Service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvToObjectPopulationTests
{
	@Test
	void testForAbilityToPopulateOrganization()
	{
		List<Organization> organizations = new ArrayList<>();
		ReadFromCSV.readIntoOrganization(organizations);
		var lengthOfUUID = 36;
		assertEquals(lengthOfUUID, organizations.get(1).id.length());
	}
	@Test
	void testForAbilityToPopulatePrograms()
	{
		List<Program> programs = new ArrayList<>();
		ReadFromCSV.readIntoPrograms(programs);
		var lengthOfUUID = 36;
		assertEquals(lengthOfUUID, programs.get(1).id.length());
	}
	@Test
	void testForAbilityToPopulateLocation()
	{
		List<Location> locations = new ArrayList<>();
		ReadFromCSV.readIntoLocation(locations);
		var lengthOfUUID = 36;
		assertEquals(lengthOfUUID, locations.get(1).id.length());
	}
	@Test
	void testForAbilityToPopulateServices()
	{
		List<Service> services = new ArrayList<>();
		ReadFromCSV.readIntoServices(services);
		var lengthOfUUID = 36;
		assertEquals(lengthOfUUID, services.get(1).id.length());
	}

}
