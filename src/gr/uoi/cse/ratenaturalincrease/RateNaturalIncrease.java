package gr.uoi.cse.ratenaturalincrease;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = RateNaturalIncreaseParser.class, parseDirectory = "resources/birth_death_growth_rates.csv", outputDirectory = "output/rate_natural_increases.txt")
public final class RateNaturalIncrease
{
	private Integer countryId;
	private Integer year;
	private Float rateNaturalIncrease;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getRateNaturalIncrease());
	}
}