package gr.uoi.cse.gdppercapita;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = GDPPerCapitaParser.class, parseDirectory = "resources/Income by Country.xlsx", outputDirectory = "output/gdp_per_capita.txt")
public class GDPPerCapita
{
	private Integer countryId;
	private Integer year;
	private Float gdpPerCapita;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getGdpPerCapita());
	}
}