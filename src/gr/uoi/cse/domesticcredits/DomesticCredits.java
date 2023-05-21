package gr.uoi.cse.domesticcredits;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DomesticCredits
{
	private Integer countryId;
	private Integer year;
	private Float domesticCredits;
}