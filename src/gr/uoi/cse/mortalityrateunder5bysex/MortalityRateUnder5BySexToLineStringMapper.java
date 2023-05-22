package gr.uoi.cse.mortalityrateunder5bysex;

import gr.uoi.cse.mapper.Mapper;

public final class MortalityRateUnder5BySexToLineStringMapper implements Mapper<MortalityRateUnder5BySex, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(MortalityRateUnder5BySex mortalityRateUnder5BySex)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(mortalityRateUnder5BySex.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRateUnder5BySex.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRateUnder5BySex.getSex().toString());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRateUnder5BySex.getMortalityRateUnder5());
		
		return stringBuilder.toString();
	}
}