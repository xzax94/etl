package gr.uoi.cse.lifeexpectancybysex;

import gr.uoi.cse.etl.ETL;
import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = LifeExpectancyBySexParser.class, parseDirectory = "resources/mortality_life_expectancy.csv", outputDirectory = "output/life_expectancy_by_sex.txt")
public class LifeExpectancyBySex
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float lifeExpectancy;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s;%s", getCountryId(), getYear(), getSex().toString(), getLifeExpectancy());
	}
}