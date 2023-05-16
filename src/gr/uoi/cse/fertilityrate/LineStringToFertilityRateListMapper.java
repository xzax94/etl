package gr.uoi.cse.fertilityrate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.Mapper;

public final class LineStringToFertilityRateListMapper implements Mapper<String, List<FertilityRate>>
{
	private static final String LINE_DELIMETER = ",";
	private static final int COUNTRY_CODE_INDEX = 0;
	private static final int YEAR_INDEX = 2;
	private static final List<Integer> FERTILITY_RATE_HEADER_INDEXES = List.of(3, 4, 5, 6, 7, 8, 9);
	private static final List<String> FERTILITY_RATE_HEADER_NAMES = List.of("fertility_rate_15_19",
			"fertility_rate_20_24",
			"fertility_rate_25_29", 
			"fertility_rate_30_34", 
			"fertility_rate_35_39",
			"fertility_rate_40_44",
			"fertility_rate_45_49");
	
	@Override
	public List<FertilityRate> map(String line) 
	{
		final List<FertilityRate> fertilityRateList = new ArrayList<>();
		final String[] lineArray = line.split(LINE_DELIMETER);
		final String countryCode = lineArray[COUNTRY_CODE_INDEX];
		final Country country = CountryCache.getInstance().getCountryByFips(countryCode);
		if (country == null)
			return Collections.emptyList();
		
		final Integer year = parseInteger(lineArray[YEAR_INDEX]);
		
		for (int i = 0; i < FERTILITY_RATE_HEADER_INDEXES.size(); i++)
		{
			final int fertilityRateIndex = FERTILITY_RATE_HEADER_INDEXES.get(i);
			final Float fertilityRateFloat = parseFloat(lineArray[fertilityRateIndex]);
			final String fertilityRateHeader = FERTILITY_RATE_HEADER_NAMES.get(i);
			
			final int minAge = getMinAge(fertilityRateHeader);
			final int maxAge = getMaxAge(fertilityRateHeader);
			
			for (int age = minAge; age <= maxAge; age++)
			{
				final FertilityRate fertilityRate = FertilityRate.builder().countryId(country.getId()).year(year).age(age).fertilityRate(fertilityRateFloat).build();
				fertilityRateList.add(fertilityRate);
			}
		}
		
		return fertilityRateList;
	}
	
	private final int getMinAge(String fertilityRateHeader)
	{
		return 0; //TODO
	}
	
	private final int getMaxAge(String fertilityRateHeader)
	{
		return 0;
	}
}