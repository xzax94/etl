package gr.uoi.cse.labourshareofgdp;

import gr.uoi.cse.mapper.Mapper;

public final class LabourShareOfGDPToLineStringMapper implements Mapper<LabourShareOfGDP, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(LabourShareOfGDP labourShareOfGDP)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(labourShareOfGDP.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(labourShareOfGDP.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(labourShareOfGDP.getLabourShareOfGDP());
		
		return stringBuilder.toString();
	}
}