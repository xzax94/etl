package gr.uoi.cse.estimatedgni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.XlsxRowMapper;
import gr.uoi.cse.sex.Sex;
import lombok.Data;

@Data
public final class XlsxRowToEstimatedGNIMapper implements XlsxRowMapper<List<EstimatedGNI>>
{
	private static final int COUNTRY_NAME_CELL_INDEX = 0;
	private final Sex sex;
	
	@Override
	public List<EstimatedGNI> map(Row row, Row headerRow) 
	{
		final Cell countryNameCell = row.getCell(COUNTRY_NAME_CELL_INDEX);
		final String countryName = getCellStringValue(countryNameCell);
		final Country country = CountryCache.getInstance().getCountryByName(countryName);
		if (country == null)
			return Collections.emptyList();
		
		final List<EstimatedGNI> estimatedGNIMaleList = new ArrayList<>();
		
		for (int i = 1; i <= headerRow.getLastCellNum(); i++)
		{
			final Cell yearCell = headerRow.getCell(i);
			if (yearCell == null)
				continue;
			
			final String yearString = getCellStringValue(yearCell);
			final Integer year = parseInteger(yearString);
			if (year == null)
				continue;
			
			final Cell estimatedGNIMaleCell = row.getCell(i);
			if (estimatedGNIMaleCell == null)
				continue;
			
			final String estimatedGNIMaleString = getCellStringValue(estimatedGNIMaleCell);
			final Float estimatedGNIMaleFloat = parseFloat(estimatedGNIMaleString);
			if (estimatedGNIMaleFloat == null)
				continue;
			
			final EstimatedGNI estimatedGNIMale = EstimatedGNI
					.builder()
					.countryId(country.getId())
					.year(year)
					.sex(sex)
					.estimatedGNI(estimatedGNIMaleFloat)
					.build();
			
			estimatedGNIMaleList.add(estimatedGNIMale);
		}
		
		return estimatedGNIMaleList;
	}
}