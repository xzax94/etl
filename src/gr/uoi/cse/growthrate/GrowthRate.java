package gr.uoi.cse.growthrate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class GrowthRate
{
	private Integer countryId;
	private Integer year;
	private Float growthRate;
}