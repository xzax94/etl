package gr.uoi.cse.infantmortalitybysex;

import java.util.Collections;
import java.util.List;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;
import gr.uoi.cse.sex.Sex;

public final class LineStringToInfantMortalityBySexMapper implements Mapper<String, List<InfantMortalityBySex>>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int INFANT_MORTALITY_MALE_INDEX = 4;
	private static final int INFANT_MORTALITY_FEMALE_INDEX = 5;

	@Override
	public List<InfantMortalityBySex> map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return Collections.emptyList();
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		final Float maleRate = parseFloat(lineArray[INFANT_MORTALITY_MALE_INDEX]);
		final Float femaleRate = parseFloat(lineArray[INFANT_MORTALITY_FEMALE_INDEX]);
		
		final InfantMortalityBySex maleInfantMortalityBySex = InfantMortalityBySex
				.builder()
				.countryId(country.getId())
				.year(year)
				.infantMortality(maleRate)
				.sex(Sex.MALE)
				.build();
		
		final InfantMortalityBySex femaleInfantMortalityBySex = InfantMortalityBySex
				.builder()
				.countryId(country.getId())
				.year(year)
				.infantMortality(femaleRate)
				.sex(Sex.FEMALE)
				.build();

		return List.of(maleInfantMortalityBySex, femaleInfantMortalityBySex);
	}
}