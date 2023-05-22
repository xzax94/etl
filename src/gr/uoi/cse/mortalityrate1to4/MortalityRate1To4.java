package gr.uoi.cse.mortalityrate1to4;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MortalityRate1To4
{
	private Integer countryId;
	private Integer year;
	private Float mortalityRate1To4;
}