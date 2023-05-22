package gr.uoi.cse.lifeexpectancy;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LifeExpectancy
{
	private Integer countryId;
	private Integer year;
	private Float lifeExpectancy;
}