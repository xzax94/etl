package gr.uoi.cse.crudedeathrate;

import gr.uoi.cse.mapper.Mapper;

public final class CrudeDeathRateToLineStringMapper implements Mapper<CrudeDeathRate, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(CrudeDeathRate crudeDeathRate)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(crudeDeathRate.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(crudeDeathRate.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(crudeDeathRate.getCrudeDeathRate());
		
		return stringBuilder.toString();
	}
}