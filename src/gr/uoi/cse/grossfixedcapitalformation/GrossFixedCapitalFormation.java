package gr.uoi.cse.grossfixedcapitalformation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class GrossFixedCapitalFormation
{
	private Integer countryId;
	private Integer year;
	private Float grossFixedCapitalFormation;
}