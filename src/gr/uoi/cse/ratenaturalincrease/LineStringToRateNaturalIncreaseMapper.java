package gr.uoi.cse.ratenaturalincrease;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToRateNaturalIncreaseMapper implements Mapper<String, RateNaturalIncrease>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int RATE_NATURAL_INCREASE_INDEX = 6;

	@Override
	public RateNaturalIncrease map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[RATE_NATURAL_INCREASE_INDEX]);
		
		final RateNaturalIncrease rateNaturalIncrease = RateNaturalIncrease
				.builder()
				.countryId(country.getId())
				.year(year)
				.rateNaturalIncrease(rate)
				.build();

		return rateNaturalIncrease;
	}
}