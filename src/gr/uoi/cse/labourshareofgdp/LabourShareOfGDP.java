package gr.uoi.cse.labourshareofgdp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LabourShareOfGDP
{
	private Integer countryId;
	private Integer year;
	private Float labourShareOfGDP;
}