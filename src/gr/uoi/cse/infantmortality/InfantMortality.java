package gr.uoi.cse.infantmortality;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfantMortality
{
	private Integer countryId;
	private Integer year;
	private Float infantMortality;
}