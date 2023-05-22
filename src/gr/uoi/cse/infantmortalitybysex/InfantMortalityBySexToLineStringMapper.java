package gr.uoi.cse.infantmortalitybysex;

import gr.uoi.cse.mapper.Mapper;

public final class InfantMortalityBySexToLineStringMapper implements Mapper<InfantMortalityBySex, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(InfantMortalityBySex infantMortality)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(infantMortality.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(infantMortality.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(infantMortality.getSex().toString());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(infantMortality.getInfantMortality());
		
		return stringBuilder.toString();
	}
}