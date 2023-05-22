package gr.uoi.cse.midyearpopulationbyagesex;

import gr.uoi.cse.mapper.Mapper;

public final class MidYearPopulationByAgeSexToLineStringMapper implements Mapper<MidYearPopulationByAgeSex, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(MidYearPopulationByAgeSex midyearPopulationByAgeSex)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(midyearPopulationByAgeSex.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(midyearPopulationByAgeSex.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(midyearPopulationByAgeSex.getAge());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(midyearPopulationByAgeSex.getSex().toString());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(midyearPopulationByAgeSex.getMidyearPopulation());
		
		return stringBuilder.toString();
	}
}