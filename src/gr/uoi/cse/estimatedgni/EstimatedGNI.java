package gr.uoi.cse.estimatedgni;

import gr.uoi.cse.sex.Sex;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstimatedGNI
{
	private Integer countryId;
	private Integer year;
	private Sex sex;
	private Float estimatedGNI;
}