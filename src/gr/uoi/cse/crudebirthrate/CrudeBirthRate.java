package gr.uoi.cse.crudebirthrate;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = CrudeBirthRateParser.class, parseDirectory = "resources/birth_death_growth_rates.csv", outputDirectory = "output/crude_birth_rates.txt")
public class CrudeBirthRate
{
	private Integer countryId;
	private Integer year;
	private Float crudeBirthRate;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getCrudeBirthRate());
	}
}