package gr.uoi.cse.sexratioatbirth;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToSexRatioAtBirthMapper implements Mapper<String, SexRatioAtBirth>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int SEX_RATIO_AT_BIRTH_INDEX = 12;

	@Override
	public SexRatioAtBirth map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return null;
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float rate = parseFloat(lineArray[SEX_RATIO_AT_BIRTH_INDEX]);
		
		final SexRatioAtBirth sexRatioAtBirth = SexRatioAtBirth
				.builder()
				.countryId(country.getId())
				.year(year)
				.sexRatioAtBirth(rate)
				.build();

		return sexRatioAtBirth;
	}
}