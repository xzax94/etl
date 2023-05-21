package gr.uoi.cse.incomeindex;

import gr.uoi.cse.mapper.Mapper;

public final class IncomeIndexToLineStringMapper implements Mapper<IncomeIndex, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(IncomeIndex incomeIndex)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(incomeIndex.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(incomeIndex.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(incomeIndex.getIncomeIndex());
		
		return stringBuilder.toString();
	}
}