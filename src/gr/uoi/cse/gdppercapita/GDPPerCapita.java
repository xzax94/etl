package gr.uoi.cse.gdppercapita;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GDPPerCapita
{
	private Integer countryId;
	private Integer year;
	private Float gdpPerCapita;
}