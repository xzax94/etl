package gr.uoi.cse.domesticcredits;

import gr.uoi.cse.mapper.Mapper;

public final class DomesticCreditsToLineStringMapper implements Mapper<DomesticCredits, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(DomesticCredits domesticCredits)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(domesticCredits.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(domesticCredits.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(domesticCredits.getDomesticCredits());
		
		return stringBuilder.toString();
	}
}