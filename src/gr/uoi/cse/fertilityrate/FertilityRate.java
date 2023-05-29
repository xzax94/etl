package gr.uoi.cse.fertilityrate;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = FertilityRateParser.class, parseDirectory = "resources/age_specific_fertility_rates.csv", outputDirectory = "output/fertility_rates.txt")
public final class FertilityRate
{
	private Integer countryId;
	private Integer year;
	private Integer age;
	private Float fertilityRate;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%d;%s", getCountryId(), getYear(), getAge(), getFertilityRate());
	}
}