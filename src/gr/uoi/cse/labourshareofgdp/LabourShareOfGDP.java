package gr.uoi.cse.labourshareofgdp;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = LabourShareOfGDPParser.class, parseDirectory = "resources/Income by Country.xlsx", outputDirectory = "output/labour_share_of_gdp.txt")
public class LabourShareOfGDP
{
	private Integer countryId;
	private Integer year;
	private Float labourShareOfGDP;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getLabourShareOfGDP());
	}
}