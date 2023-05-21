package gr.uoi.cse.domesticcredits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.XlsxRowMapper;

public final class XlsxRowToDomesticCreditsMapper implements XlsxRowMapper<List<DomesticCredits>>
{
	private static final int COUNTRY_NAME_CELL_INDEX = 0;
	
	@Override
	public List<DomesticCredits> map(Row row, Row headerRow) 
	{
		final Cell countryNameCell = row.getCell(COUNTRY_NAME_CELL_INDEX);
		final String countryName = getCellStringValue(countryNameCell);
		final Country country = CountryCache.getInstance().getCountryByName(countryName);
		if (country == null)
			return Collections.emptyList();
		
		final List<DomesticCredits> domesticCreditsList = new ArrayList<>();
		
		for (int i = 1; i <= headerRow.getLastCellNum(); i++)
		{
			final Cell yearCell = headerRow.getCell(i);
			if (yearCell == null)
				continue;
			
			final String yearString = getCellStringValue(yearCell);
			final Integer year = parseInteger(yearString);
			if (year == null)
				continue;
			
			final Cell domesticCreditsCell = row.getCell(i);
			if (domesticCreditsCell == null)
				continue;
			
			final String domesticCreditsString = getCellStringValue(domesticCreditsCell);
			final Float domesticCreditsFloat = parseFloat(domesticCreditsString);
			if (domesticCreditsFloat == null)
				continue;
			
			final DomesticCredits domesticCredits = DomesticCredits
					.builder()
					.countryId(country.getId())
					.year(year)
					.domesticCredits(domesticCreditsFloat)
					.build();
			
			domesticCreditsList.add(domesticCredits);
		}
		
		return domesticCreditsList;
	}
}