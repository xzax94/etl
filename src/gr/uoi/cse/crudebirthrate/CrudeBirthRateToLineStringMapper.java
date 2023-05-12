package gr.uoi.cse.crudebirthrate;

import gr.uoi.cse.mapper.Mapper;

public final class CrudeBirthRateToLineStringMapper implements Mapper<CrudeBirthRate, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(CrudeBirthRate crudeBirthRate)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(crudeBirthRate.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(crudeBirthRate.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(crudeBirthRate.getCrudeBirthRate());
		
		return stringBuilder.toString();
	}
}