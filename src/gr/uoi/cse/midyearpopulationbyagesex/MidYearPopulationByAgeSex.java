package gr.uoi.cse.midyearpopulationbyagesex;

import gr.uoi.cse.etl.ETL;
import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = MidYearPopulationByAgeSexParser.class, parseDirectory = "resources/midyear_population_age_sex.csv", outputDirectory = "output/midyear_population_by_age_sex.txt")
public final class MidYearPopulationByAgeSex
{
	private Integer countryId;
	private Integer year;
	private Integer age;
	private Sex sex;
	private Float midyearPopulation;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%d;%s;%s", getCountryId(), getYear(), getAge(), getSex().toString(), getMidyearPopulation());
	}
}