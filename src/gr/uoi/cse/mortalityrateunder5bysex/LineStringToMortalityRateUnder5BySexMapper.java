package gr.uoi.cse.mortalityrateunder5bysex;

import java.util.Collections;
import java.util.List;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;
import gr.uoi.cse.sex.Sex;

public final class LineStringToMortalityRateUnder5BySexMapper implements Mapper<String, List<MortalityRateUnder5BySex>>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int MORTALITY_RATE_MALE_INDEX = 10;
	private static final int MORTALITY_RATE_FEMALE_INDEX = 11;

	@Override
	public List<MortalityRateUnder5BySex> map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return Collections.emptyList();
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float maleRate = parseFloat(lineArray[MORTALITY_RATE_MALE_INDEX]);
		final Float femaleRate = parseFloat(lineArray[MORTALITY_RATE_FEMALE_INDEX]);
		
		final MortalityRateUnder5BySex maleMortalityRateUnder5BySex = MortalityRateUnder5BySex
				.builder()
				.countryId(country.getId())
				.year(year)
				.mortalityRateUnder5(maleRate)
				.sex(Sex.MALE)
				.build();
		
		final MortalityRateUnder5BySex femaleMortalityRateUnder5BySex = MortalityRateUnder5BySex
				.builder()
				.countryId(country.getId())
				.year(year)
				.mortalityRateUnder5(femaleRate)
				.sex(Sex.FEMALE)
				.build();

		return List.of(maleMortalityRateUnder5BySex, femaleMortalityRateUnder5BySex);
	}
}