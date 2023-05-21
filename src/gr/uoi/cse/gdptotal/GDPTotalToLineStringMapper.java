package gr.uoi.cse.gdptotal;

import gr.uoi.cse.mapper.Mapper;

public final class GDPTotalToLineStringMapper implements Mapper<GDPTotal, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(GDPTotal gdpTotal)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(gdpTotal.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(gdpTotal.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(gdpTotal.getGdpTotal());
		
		return stringBuilder.toString();
	}
}