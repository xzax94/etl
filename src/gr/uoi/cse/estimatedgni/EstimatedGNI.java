package gr.uoi.cse.estimatedgni;

import gr.uoi.cse.etl.ETL;
import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = EstimatedGNIParser.class, parseDirectory = "resources/Income by Country.xlsx", outputDirectory = "output/estimated_gni.txt")
public class EstimatedGNI
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float estimatedGNI;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s;%s", getCountryId(), getYear(), getSex().toString(), getEstimatedGNI());
	}
}