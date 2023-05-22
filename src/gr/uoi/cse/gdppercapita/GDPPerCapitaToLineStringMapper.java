package gr.uoi.cse.gdppercapita;

import gr.uoi.cse.mapper.Mapper;

public final class GDPPerCapitaToLineStringMapper implements Mapper<GDPPerCapita, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(GDPPerCapita gdpPerCapita)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(gdpPerCapita.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(gdpPerCapita.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(gdpPerCapita.getGdpPerCapita());
		
		return stringBuilder.toString();
	}
}