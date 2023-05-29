package gr.uoi.cse.grossreproductionrate;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = GrossReproductionRateParser.class, parseDirectory = "resources/age_specific_fertility_rates.csv", outputDirectory = "output/gross_reproduction_rates.txt")
public final class GrossReproductionRate
{
	private Integer countryId;
	private Integer year;
	private Float grossReproductionRate;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getGrossReproductionRate());
	}
}