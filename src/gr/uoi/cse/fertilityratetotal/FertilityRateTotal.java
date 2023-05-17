package gr.uoi.cse.fertilityratetotal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class FertilityRateTotal
{
	private Integer countryId;
	private Integer year;
	private Float fertilityRateTotal;
}