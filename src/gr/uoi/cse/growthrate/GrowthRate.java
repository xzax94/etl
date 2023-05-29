package gr.uoi.cse.growthrate;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = GrowthRateParser.class, parseDirectory = "resources/birth_death_growth_rates.csv", outputDirectory = "output/growth_rates.txt")
public final class GrowthRate
{
	private Integer countryId;
	private Integer year;
	private Float growthRate;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getGrowthRate());
	}
}