package gr.uoi.cse.gdptotal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.XlsxRowMapper;

public final class XlsxRowToGDPTotalMapper implements XlsxRowMapper<List<GDPTotal>>
{
	private static final int COUNTRY_NAME_CELL_INDEX = 0;
	
	@Override
	public List<GDPTotal> map(Row row, Row headerRow) 
	{
		final Cell countryNameCell = row.getCell(COUNTRY_NAME_CELL_INDEX);
		final String countryName = getCellStringValue(countryNameCell);
		final Country country = CountryCache.getInstance().getCountryByName(countryName);
		if (country == null)
			return Collections.emptyList();
		
		final List<GDPTotal> gdpTotalList = new ArrayList<>();
		
		for (int i = 1; i <= headerRow.getLastCellNum(); i++)
		{
			final Cell yearCell = headerRow.getCell(i);
			if (yearCell == null)
				continue;
			
			final String yearString = getCellStringValue(yearCell);
			final Integer year = parseInteger(yearString);
			if (year == null)
				continue;
			
			final Cell gdpTotalCell = row.getCell(i);
			if (gdpTotalCell == null)
				continue;
			
			final String gdpTotalString = getCellStringValue(gdpTotalCell);
			final Float gdpTotalFloat = parseFloat(gdpTotalString);
			if (gdpTotalFloat == null)
				continue;
			
			final GDPTotal gdpTotal = GDPTotal
					.builder()
					.countryId(country.getId())
					.year(year)
					.gdpTotal(gdpTotalFloat)
					.build();
			
			gdpTotalList.add(gdpTotal);
		}
		
		return gdpTotalList;
	}
}