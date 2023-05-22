package gr.uoi.cse.lifeexpectancy;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToLifeExpectancyMapper implements Mapper<String, LifeExpectancy>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int INFANT_MORTALITY_INDEX = 6;

	@Override
	public LifeExpectancy map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[INFANT_MORTALITY_INDEX]);
		
		final LifeExpectancy midyearPopulation = LifeExpectancy
				.builder()
				.countryId(country.getId())
				.year(year)
				.lifeExpectancy(rate)
				.build();

		return midyearPopulation;
	}
}