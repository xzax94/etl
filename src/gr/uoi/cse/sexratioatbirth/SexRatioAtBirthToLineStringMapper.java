package gr.uoi.cse.sexratioatbirth;

import gr.uoi.cse.mapper.Mapper;

public final class SexRatioAtBirthToLineStringMapper implements Mapper<SexRatioAtBirth, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(SexRatioAtBirth sexRatioAtBirth)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(sexRatioAtBirth.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(sexRatioAtBirth.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(sexRatioAtBirth.getSexRatioAtBirth());
		
		return stringBuilder.toString();
	}
}