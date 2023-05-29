package gr.uoi.cse.infantmortalitybysex;

import gr.uoi.cse.etl.ETL;
import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = InfantMortalityBySexParser.class, parseDirectory = "resources/mortality_life_expectancy.csv", outputDirectory = "output/infant_mortality_by_sex.txt")
public class InfantMortalityBySex
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float infantMortality;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s,%s", getCountryId(), getYear(), getSex().toString(), getInfantMortality());
	}
}