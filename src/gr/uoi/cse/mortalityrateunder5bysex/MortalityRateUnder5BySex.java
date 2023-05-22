package gr.uoi.cse.mortalityrateunder5bysex;

import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MortalityRateUnder5BySex
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float mortalityRateUnder5;
}