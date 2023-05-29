package gr.uoi.cse.mortalityrate1to4bysex;

import gr.uoi.cse.etl.ETL;
import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ETL(parserClass = MortalityRate1To4BySexParser.class, parseDirectory = "resources/mortality_life_expectancy.csv", outputDirectory = "output/mortality_rate_1_to_4_by_sex.txt")
public class MortalityRate1To4BySex
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float mortalityRate1To4;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s;%s", getCountryId(), getYear(), getSex().toString(), getMortalityRate1To4());
	}
}