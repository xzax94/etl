package gr.uoi.cse.mortalityrateunder5;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MortalityRateUnder5
{
	private Integer countryId;
	private Integer year;
	private Float mortalityRateUnder5;
}