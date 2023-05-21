package gr.uoi.cse.incomeindex;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IncomeIndex
{
	private Integer countryId;
	private Integer year;
	private Float incomeIndex;
}