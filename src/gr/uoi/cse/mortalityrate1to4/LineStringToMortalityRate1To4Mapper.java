package gr.uoi.cse.mortalityrate1to4;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToMortalityRate1To4Mapper implements Mapper<String, MortalityRate1To4>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int MORTALITY_RATE_INDEX = 12;

	@Override
	public MortalityRate1To4 map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[MORTALITY_RATE_INDEX]);
		
		final MortalityRate1To4 midyearPopulation = MortalityRate1To4
				.builder()
				.countryId(country.getId())
				.year(year)
				.mortalityRate1To4(rate)
				.build();

		return midyearPopulation;
	}
}