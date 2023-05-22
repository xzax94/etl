package gr.uoi.cse.mortalityrateunder5;

import gr.uoi.cse.mapper.Mapper;

public final class MortalityRateUnder5ToLineStringMapper implements Mapper<MortalityRateUnder5, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(MortalityRateUnder5 mortalityRateUnder5)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(mortalityRateUnder5.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRateUnder5.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(mortalityRateUnder5.getMortalityRateUnder5());
		
		return stringBuilder.toString();
	}
}