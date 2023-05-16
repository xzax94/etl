package gr.uoi.cse.fertilityrate;

import gr.uoi.cse.mapper.Mapper;

public final class FertilityRateToLineStringMapper implements Mapper<FertilityRate, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(FertilityRate netMigration)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(netMigration.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(netMigration.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(netMigration.getAge());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(netMigration.getFertilityRate());
		
		return stringBuilder.toString();
	}
}