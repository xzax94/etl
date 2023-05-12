package gr.uoi.cse.netmigration;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToNetMigrationMapper implements Mapper<String, NetMigration>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int NET_MIGRATION_INDEX = 5;

	@Override
	public NetMigration map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[NET_MIGRATION_INDEX]);
		
		final NetMigration netMigration = NetMigration
				.builder()
				.countryId(country.getId())
				.year(year)
				.netMigration(rate)
				.build();

		return netMigration;
	}
}