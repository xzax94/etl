package gr.uoi.cse.domesticcredits;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ETL(parserClass = DomesticCreditsParser.class, parseDirectory = "resources/Income by Country.xlsx", outputDirectory = "output/domestic_credits.txt")
public class DomesticCredits
{
	private Integer countryId;
	private Integer year;
	private Float domesticCredits;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getDomesticCredits());
	}
}