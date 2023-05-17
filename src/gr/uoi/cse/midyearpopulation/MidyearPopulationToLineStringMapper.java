package gr.uoi.cse.midyearpopulation;

import gr.uoi.cse.mapper.Mapper;

public final class MidyearPopulationToLineStringMapper implements Mapper<MidyearPopulation, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(MidyearPopulation midyearPopulation)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(midyearPopulation.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(midyearPopulation.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(midyearPopulation.getMidyearPopulation());
		
		return stringBuilder.toString();
	}
}