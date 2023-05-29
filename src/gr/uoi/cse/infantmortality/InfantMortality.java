package gr.uoi.cse.infantmortality;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = InfantMortalityParser.class, parseDirectory = "resources/mortality_life_expectancy.csv", outputDirectory = "output/infant_mortality.txt")
public class InfantMortality
{
	private Integer countryId;
	private Integer year;
	private Float infantMortality;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getInfantMortality());
	}
}