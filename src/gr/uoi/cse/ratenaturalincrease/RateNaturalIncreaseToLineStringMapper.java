package gr.uoi.cse.ratenaturalincrease;

import gr.uoi.cse.mapper.Mapper;

public final class RateNaturalIncreaseToLineStringMapper implements Mapper<RateNaturalIncrease, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(RateNaturalIncrease rateNaturalIncrease)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(rateNaturalIncrease.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(rateNaturalIncrease.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(rateNaturalIncrease.getRateNaturalIncrease());
		
		return stringBuilder.toString();
	}
}