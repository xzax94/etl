package gr.uoi.cse.mortalityrate1to4bysex;

import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MortalityRate1To4BySex
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float mortalityRate1To4;
}