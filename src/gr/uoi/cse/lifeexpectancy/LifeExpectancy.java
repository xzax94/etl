package gr.uoi.cse.lifeexpectancy;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = LifeExpectancyParser.class, parseDirectory = "resources/mortality_life_expectancy.csv", outputDirectory = "output/life_expectancy.txt")
public class LifeExpectancy
{
	private Integer countryId;
	private Integer year;
	private Float lifeExpectancy;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getLifeExpectancy());
	}
}