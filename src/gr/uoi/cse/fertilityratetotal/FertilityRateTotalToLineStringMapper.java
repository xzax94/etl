package gr.uoi.cse.fertilityratetotal;

import gr.uoi.cse.mapper.Mapper;

public final class FertilityRateTotalToLineStringMapper implements Mapper<FertilityRateTotal, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(FertilityRateTotal fertilityRateTotal)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(fertilityRateTotal.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(fertilityRateTotal.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(fertilityRateTotal.getFertilityRateTotal());
		
		return stringBuilder.toString();
	}
}