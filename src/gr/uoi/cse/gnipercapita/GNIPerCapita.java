package gr.uoi.cse.gnipercapita;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = GNIPerCapitaParser.class, parseDirectory = "resources/Income by Country.xlsx", outputDirectory = "output/gni_per_capita.txt")
public class GNIPerCapita
{
	private Integer countryId;
	private Integer year;
	private Float gniPerCapita;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getGniPerCapita());
	}
}