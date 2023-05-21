package gr.uoi.cse.grossfixedcapitalformation;

import gr.uoi.cse.mapper.Mapper;

public final class GrossFixedCapitalFormationToLineStringMapper implements Mapper<GrossFixedCapitalFormation, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(GrossFixedCapitalFormation grossFixedCapitalFormation)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(grossFixedCapitalFormation.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(grossFixedCapitalFormation.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(grossFixedCapitalFormation.getGrossFixedCapitalFormation());
		
		return stringBuilder.toString();
	}
}