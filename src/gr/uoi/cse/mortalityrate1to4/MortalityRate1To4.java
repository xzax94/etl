package gr.uoi.cse.mortalityrate1to4;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = MortalityRate1To4Parser.class, parseDirectory = "resources/mortality_life_expectancy.csv", outputDirectory = "output/mortality_rate_1_to_4.txt")
public class MortalityRate1To4
{
	private Integer countryId;
	private Integer year;
	private Float mortalityRate1To4;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getMortalityRate1To4());
	}
}