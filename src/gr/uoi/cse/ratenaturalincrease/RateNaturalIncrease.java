package gr.uoi.cse.ratenaturalincrease;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class RateNaturalIncrease
{
	private Integer countryId;
	private Integer year;
	private Float rateNaturalIncrease;
}