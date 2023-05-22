package gr.uoi.cse.mortalityrate1to4bysex;

import java.util.Collections;
import java.util.List;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;
import gr.uoi.cse.sex.Sex;

public final class LineStringToMortalityRate1To4BySexMapper implements Mapper<String, List<MortalityRate1To4BySex>>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int MORTALITY_RATE_MALE_INDEX = 13;
	private static final int MORTALITY_RATE_FEMALE_INDEX = 14;

	@Override
	public List<MortalityRate1To4BySex> map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return Collections.emptyList();
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float maleRate = parseFloat(lineArray[MORTALITY_RATE_MALE_INDEX]);
		final Float femaleRate = parseFloat(lineArray[MORTALITY_RATE_FEMALE_INDEX]);
		
		final MortalityRate1To4BySex maleMortalityRate1To4BySex = MortalityRate1To4BySex
				.builder()
				.countryId(country.getId())
				.year(year)
				.mortalityRate1To4(maleRate)
				.sex(Sex.MALE)
				.build();
		
		final MortalityRate1To4BySex femaleMortalityRate1To4BySex = MortalityRate1To4BySex
				.builder()
				.countryId(country.getId())
				.year(year)
				.mortalityRate1To4(femaleRate)
				.sex(Sex.FEMALE)
				.build();

		return List.of(maleMortalityRate1To4BySex, femaleMortalityRate1To4BySex);
	}
}