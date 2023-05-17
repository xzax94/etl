package gr.uoi.cse.grossreproductionrate;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToGrossReproductionRateMapper implements Mapper<String, GrossReproductionRate>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int GROSS_REPRODUCTION_RATE_INDEX = 11;

	@Override
	public GrossReproductionRate map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[GROSS_REPRODUCTION_RATE_INDEX]);
		
		final GrossReproductionRate grossReproductionRate = GrossReproductionRate
				.builder()
				.countryId(country.getId())
				.year(year)
				.grossReproductionRate(rate)
				.build();

		return grossReproductionRate;
	}
}