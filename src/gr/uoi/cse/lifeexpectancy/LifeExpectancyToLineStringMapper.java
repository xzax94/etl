package gr.uoi.cse.lifeexpectancy;

import gr.uoi.cse.mapper.Mapper;

public final class LifeExpectancyToLineStringMapper implements Mapper<LifeExpectancy, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(LifeExpectancy lifeExpectancy)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(lifeExpectancy.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(lifeExpectancy.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(lifeExpectancy.getLifeExpectancy());
		
		return stringBuilder.toString();
	}
}