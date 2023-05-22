package gr.uoi.cse.lifeexpectancybysex;

import gr.uoi.cse.mapper.Mapper;

public final class LifeExpectancyBySexToLineStringMapper implements Mapper<LifeExpectancyBySex, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(LifeExpectancyBySex lifeExpectancyBySex)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(lifeExpectancyBySex.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(lifeExpectancyBySex.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(lifeExpectancyBySex.getSex().toString());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(lifeExpectancyBySex.getLifeExpectancy());
		
		return stringBuilder.toString();
	}
}