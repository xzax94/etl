package gr.uoi.cse.midyearpopulationbyagesex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;
import gr.uoi.cse.sex.Sex;

public final class LineStringToMidYearPopulationByAgeSexMapper implements Mapper<String, List<MidYearPopulationByAgeSex>>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final int SEX_INDEX = 3;
	private static final int FIRST_AGE_INDEX = 5;
	private static final int LAST_AGE_INDEX = 105;

	@Override
	public List<MidYearPopulationByAgeSex> map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return Collections.emptyList();
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		if (year == null)
			return Collections.emptyList();
		
		final String sexString = lineArray[SEX_INDEX];
		if (sexString == null || sexString.isEmpty())
			return Collections.emptyList();
		
		final Sex sex = Sex.findByName(sexString);
		int age = 0;
		final List<MidYearPopulationByAgeSex> midYearPopulationByAgeSexList = new ArrayList<>();
		
		for (int i = FIRST_AGE_INDEX; i <= LAST_AGE_INDEX; i++)
		{
			final Float midyearPopulation = parseFloat(lineArray[i]);
			final MidYearPopulationByAgeSex midYearPopulationByAgeSex = MidYearPopulationByAgeSex
					.builder()
					.countryId(country.getId())
					.year(year)
					.age(age)
					.sex(sex)
					.midyearPopulation(midyearPopulation)
					.build();
			
			midYearPopulationByAgeSexList.add(midYearPopulationByAgeSex);
			age++;
		}

		return midYearPopulationByAgeSexList;
	}
}