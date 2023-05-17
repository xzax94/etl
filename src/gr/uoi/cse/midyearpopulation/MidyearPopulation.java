package gr.uoi.cse.midyearpopulation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class MidyearPopulation
{
	private Integer countryId;
	private Integer year;
	private Float midyearPopulation;
}