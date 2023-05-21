package gr.uoi.cse.gdptotal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GDPTotal
{
	private Integer countryId;
	private Integer year;
	private Float gdpTotal;
}