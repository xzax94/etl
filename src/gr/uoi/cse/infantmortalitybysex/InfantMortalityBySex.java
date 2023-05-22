package gr.uoi.cse.infantmortalitybysex;

import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfantMortalityBySex
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float infantMortality;
}