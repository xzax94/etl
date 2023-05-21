package gr.uoi.cse.incomeindex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.XlsxRowMapper;

public final class XlsxRowToIncomeIndexMapper implements XlsxRowMapper<List<IncomeIndex>>
{
	private static final int COUNTRY_NAME_CELL_INDEX = 0;
	
	@Override
	public List<IncomeIndex> map(Row row, Row headerRow) 
	{
		final Cell countryNameCell = row.getCell(COUNTRY_NAME_CELL_INDEX);
		final String countryName = getCellStringValue(countryNameCell);
		final Country country = CountryCache.getInstance().getCountryByName(countryName);
		if (country == null)
			return Collections.emptyList();
		
		final List<IncomeIndex> incomeIndexList = new ArrayList<>();
		
		for (int i = 1; i <= headerRow.getLastCellNum(); i++)
		{
			final Cell yearCell = headerRow.getCell(i);
			if (yearCell == null)
				continue;
			
			final String yearString = getCellStringValue(yearCell);
			final Integer year = parseInteger(yearString);
			if (year == null)
				continue;
			
			final Cell incomeIndexCell = row.getCell(i);
			if (incomeIndexCell == null)
				continue;
			
			final String incomeIndexString = getCellStringValue(incomeIndexCell);
			final Float incomeIndexFloat = parseFloat(incomeIndexString);
			if (incomeIndexFloat == null)
				continue;
			
			final IncomeIndex incomeIndex = IncomeIndex
					.builder()
					.countryId(country.getId())
					.year(year)
					.incomeIndex(incomeIndexFloat)
					.build();
			
			incomeIndexList.add(incomeIndex);
		}
		
		return incomeIndexList;
	}
}