package gr.uoi.cse.mortalityrateunder5;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = MortalityRateUnder5Parser.class, parseDirectory = "resources/mortality_life_expectancy.csv", outputDirectory = "output/mortality_rate_under_5.txt")
public class MortalityRateUnder5
{
	private Integer countryId;
	private Integer year;
	private Float mortalityRateUnder5;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getMortalityRateUnder5());
	}
}