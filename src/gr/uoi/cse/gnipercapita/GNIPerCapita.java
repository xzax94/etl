package gr.uoi.cse.gnipercapita;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GNIPerCapita
{
	private Integer countryId;
	private Integer year;
	private Float gniPerCapita;
}