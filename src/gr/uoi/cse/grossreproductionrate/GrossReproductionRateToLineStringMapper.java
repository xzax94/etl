package gr.uoi.cse.grossreproductionrate;

import gr.uoi.cse.mapper.Mapper;

public final class GrossReproductionRateToLineStringMapper implements Mapper<GrossReproductionRate, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(GrossReproductionRate grossReproductionRate)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(grossReproductionRate.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(grossReproductionRate.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(grossReproductionRate.getGrossReproductionRate());
		
		return stringBuilder.toString();
	}
}