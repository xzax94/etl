package gr.uoi.cse.sexratioatbirth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class SexRatioAtBirth
{
	private Integer countryId;
	private Integer year;
	private Float sexRatioAtBirth;
}