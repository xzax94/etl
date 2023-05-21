package gr.uoi.cse.estimatedgni;

import gr.uoi.cse.mapper.Mapper;

public final class EstimatedGNIToLineStringMapper implements Mapper<EstimatedGNI, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(EstimatedGNI estimatedGNI)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(estimatedGNI.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(estimatedGNI.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(estimatedGNI.getSex().toString());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(estimatedGNI.getEstimatedGNI());
		
		return stringBuilder.toString();
	}
}