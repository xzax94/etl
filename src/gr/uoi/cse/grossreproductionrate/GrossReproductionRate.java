package gr.uoi.cse.grossreproductionrate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class GrossReproductionRate
{
	private Integer countryId;
	private Integer year;
	private Float grossReproductionRate;
}