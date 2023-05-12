package gr.uoi.cse.crudedeathrate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CrudeDeathRate
{
	private Integer countryId;
	private Integer year;
	private Float crudeDeathRate;
}