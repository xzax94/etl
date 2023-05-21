package gr.uoi.cse.gnipercapita;

import gr.uoi.cse.mapper.Mapper;

public final class GNIPerCapitaToLineStringMapper implements Mapper<GNIPerCapita, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(GNIPerCapita gniPerCapita)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(gniPerCapita.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(gniPerCapita.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(gniPerCapita.getGniPerCapita());
		
		return stringBuilder.toString();
	}
}