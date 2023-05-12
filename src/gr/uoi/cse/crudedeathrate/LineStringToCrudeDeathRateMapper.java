package gr.uoi.cse.crudedeathrate;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToCrudeDeathRateMapper implements Mapper<String, CrudeDeathRate>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int CRUDE_DEATH_RATE_INDEX = 4;

	@Override
	public CrudeDeathRate map(String line) 
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[CRUDE_DEATH_RATE_INDEX]);
		
		final CrudeDeathRate crudeDeathRate = CrudeDeathRate
				.builder()
				.countryId(country.getId())
				.year(year)
				.crudeDeathRate(rate)
				.build();

		return crudeDeathRate;
	}
}