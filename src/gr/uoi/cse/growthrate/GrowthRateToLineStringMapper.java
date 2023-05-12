package gr.uoi.cse.growthrate;

import gr.uoi.cse.mapper.Mapper;

public final class GrowthRateToLineStringMapper implements Mapper<GrowthRate, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(GrowthRate growthRate)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(growthRate.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(growthRate.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(growthRate.getGrowthRate());
		
		return stringBuilder.toString();
	}
}