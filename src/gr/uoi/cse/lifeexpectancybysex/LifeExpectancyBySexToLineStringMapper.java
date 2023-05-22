package gr.uoi.cse.lifeexpectancybysex;

import gr.uoi.cse.mapper.Mapper;

public final class LifeExpectancyBySexToLineStringMapper implements Mapper<LifeExpectancyBySex, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(LifeExpectancyBySex LifeExpectancy)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(LifeExpectancy.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(LifeExpectancy.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(LifeExpectancy.getSex().toString());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(LifeExpectancy.getLifeExpectancy());
		
		return stringBuilder.toString();
	}
}