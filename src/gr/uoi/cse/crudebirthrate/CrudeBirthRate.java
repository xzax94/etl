package gr.uoi.cse.crudebirthrate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CrudeBirthRate
{
	private Integer countryId;
	private Integer year;
	private Float crudeBirthRate;
}