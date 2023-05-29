package gr.uoi.cse.fertilityratetotal;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = FertilityRateTotalParser.class, parseDirectory = "resources/age_specific_fertility_rates.csv", outputDirectory = "output/fertility_total_rates.txt")
public final class FertilityRateTotal
{
	private Integer countryId;
	private Integer year;
	private Float fertilityRateTotal;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getFertilityRateTotal());
	}
}