package gr.uoi.cse.mortalityrate1to4bysex;

import gr.uoi.cse.mapper.Mapper;

public final class MortalityRate1To4BySexToLineStringMapper implements Mapper<MortalityRate1To4BySex, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(MortalityRate1To4BySex mortalityRate1To4BySex)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(mortalityRate1To4BySex.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRate1To4BySex.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRate1To4BySex.getSex().toString());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRate1To4BySex.getMortalityRate1To4());
		
		return stringBuilder.toString();
	}
}