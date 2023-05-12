package gr.uoi.cse.country;

import gr.uoi.cse.mapper.Mapper;

public final class CountryToLineStringMapper implements Mapper<Country, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(Country country)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(country.getId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(country.getIso());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(country.getIso3());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(country.getIsoCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getFips());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getDisplayName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getOfficialName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getCapitalName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getContinentName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getCurrencyCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getCurrencyName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getPhone());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getRegionCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getRegionName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getSubRegionCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getSubRegionName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getIntermediateRegionCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getIntermediateRegionName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getStatus());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getDevelopmentStatus());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.isSids() ? 1 : 0);
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.isLldc() ? 1 : 0);
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.isLdc() ? 1 : 0);
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(country.getAreaInSquaredKm());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(country.getPopulation());
		
		return stringBuilder.toString();
	}
}