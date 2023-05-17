package gr.uoi.cse.midyearpopulation;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToMidyearPopulationMapper implements Mapper<String, MidyearPopulation>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int MIDYEAR_POPULATION_INDEX = 3;

	@Override
	public MidyearPopulation map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[MIDYEAR_POPULATION_INDEX]);
		
		final MidyearPopulation midyearPopulation = MidyearPopulation
				.builder()
				.countryId(country.getId())
				.year(year)
				.midyearPopulation(rate)
				.build();

		return midyearPopulation;
	}
}