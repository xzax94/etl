package gr.uoi.cse.gdptotal;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = GDPTotalParser.class, parseDirectory = "resources/Income by Country.xlsx", outputDirectory = "output/gdp_total.txt")
public class GDPTotal
{
	private Integer countryId;
	private Integer year;
	private Float gdpTotal;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getGdpTotal());
	}
}