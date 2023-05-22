package gr.uoi.cse.midyearpopulationbyagesex;

import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class MidYearPopulationByAgeSex
{
	private Integer countryId;
	private Integer year;
	private Integer age;
	private Sex sex;
	private Float midyearPopulation;
}