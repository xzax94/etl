package gr.uoi.cse.incomeindex;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = IncomeIndexParser.class, parseDirectory = "resources/Income by Country.xlsx", outputDirectory = "output/income_index.txt")
public class IncomeIndex
{
	private Integer countryId;
	private Integer year;
	private Float incomeIndex;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getIncomeIndex());
	}
}