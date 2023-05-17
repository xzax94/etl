package gr.uoi.cse.fertilityratetotal;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToFertilityRateTotalMapper implements Mapper<String, FertilityRateTotal>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int FERTILITY_RATE_TOTAL_INDEX = 10;

	@Override
	public FertilityRateTotal map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[FERTILITY_RATE_TOTAL_INDEX]);
		
		final FertilityRateTotal fertilityRateTotal = FertilityRateTotal
				.builder()
				.countryId(country.getId())
				.year(year)
				.fertilityRateTotal(rate)
				.build();

		return fertilityRateTotal;
	}
}