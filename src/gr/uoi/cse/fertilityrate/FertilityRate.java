package gr.uoi.cse.fertilityrate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class FertilityRate
{
	private Integer countryId;
	private Integer year;
	private Integer age;
	private Float fertilityRate;
}