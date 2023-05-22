package gr.uoi.cse.mortalityrate1to4;

import gr.uoi.cse.mapper.Mapper;

public final class MortalityRate1To4ToLineStringMapper implements Mapper<MortalityRate1To4, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(MortalityRate1To4 mortalityRate1To4)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(mortalityRate1To4.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRate1To4.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRate1To4.getMortalityRate1To4());
		
		return stringBuilder.toString();
	}
}