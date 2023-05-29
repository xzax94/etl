package gr.uoi.cse.grossfixedcapitalformation;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = GrossFixedCapitalFormationParser.class, parseDirectory = "resources/Income by Country.xlsx" , outputDirectory = "output/gross_fixed_capital_formation.txt")
public final class GrossFixedCapitalFormation
{
	private Integer countryId;
	private Integer year;
	private Float grossFixedCapitalFormation;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getGrossFixedCapitalFormation());
	}
}