package gr.uoi.cse.lifeexpectancybysex;

import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LifeExpectancyBySex
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float lifeExpectancy;
}