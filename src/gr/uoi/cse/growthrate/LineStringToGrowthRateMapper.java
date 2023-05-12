package gr.uoi.cse.growthrate;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToGrowthRateMapper implements Mapper<String, GrowthRate>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int GROWTH_RATE_INDEX = 7;

	@Override
	public GrowthRate map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[GROWTH_RATE_INDEX]);
		
		final GrowthRate growthRate = GrowthRate
				.builder()
				.countryId(country.getId())
				.year(year)
				.growthRate(rate)
				.build();

		return growthRate;
	}
}