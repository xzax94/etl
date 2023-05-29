package gr.uoi.cse.sexratioatbirth;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = SexRatioAtBirthParser.class, parseDirectory = "resources/age_specific_fertility_rates.csv", outputDirectory = "output/sex_ratio_at_birth.txt")
public final class SexRatioAtBirth
{
	private Integer countryId;
	private Integer year;
	private Float sexRatioAtBirth;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getSexRatioAtBirth());
	}
}