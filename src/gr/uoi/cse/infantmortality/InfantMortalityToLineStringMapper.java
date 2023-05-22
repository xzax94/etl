package gr.uoi.cse.infantmortality;

import gr.uoi.cse.mapper.Mapper;

public final class InfantMortalityToLineStringMapper implements Mapper<InfantMortality, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(InfantMortality infantMortality)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(infantMortality.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(infantMortality.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(infantMortality.getInfantMortality());
		
		return stringBuilder.toString();
	}
}