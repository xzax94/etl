package gr.uoi.cse.mortalityrateunder5bysex;

import gr.uoi.cse.etl.ETL;
import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = MortalityRateUnder5BySexParser.class, parseDirectory = "resources/mortality_life_expectancy.csv", outputDirectory = "output/mortality_rate_under_5_by_sex.txt")
public class MortalityRateUnder5BySex
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float mortalityRateUnder5;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s;%s", getCountryId(), getYear(), getSex().toString(), getMortalityRateUnder5());
	}
}