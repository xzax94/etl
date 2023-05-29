package gr.uoi.cse.midyearpopulation;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = MidyearPopulationParser.class, parseDirectory = "resources/midyear_population.csv", outputDirectory = "output/midyear_population.txt")
public final class MidyearPopulation
{
	private Integer countryId;
	private Integer year;
	private Float midyearPopulation;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getMidyearPopulation());
	}
}