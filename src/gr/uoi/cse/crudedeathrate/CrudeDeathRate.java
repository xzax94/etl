package gr.uoi.cse.crudedeathrate;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ETL(parserClass = CrudeDeathRateParser.class, parseDirectory = "resources/birth_death_growth_rates.csv", outputDirectory = "output/crude_death_rates.txt")
public class CrudeDeathRate
{
	private Integer countryId;
	private Integer year;
	private Float crudeDeathRate;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getCrudeDeathRate());
	}
}