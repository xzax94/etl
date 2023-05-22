package gr.uoi.cse.gdppercapita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.XlsxRowMapper;

public final class XlsxRowToGDPPerCapitaMapper implements XlsxRowMapper<List<GDPPerCapita>>
{
	private static final int COUNTRY_NAME_CELL_INDEX = 0;
	
	@Override
	public List<GDPPerCapita> map(Row row, Row headerRow) 
	{
		final Cell countryNameCell = row.getCell(COUNTRY_NAME_CELL_INDEX);
		final String countryName = getCellStringValue(countryNameCell);
		final Country country = CountryCache.getInstance().getCountryByName(countryName);
		if (country == null)
			return Collections.emptyList();
		
		final List<GDPPerCapita> gdpPerCapitaList = new ArrayList<>();
		
		for (int i = 1; i <= headerRow.getLastCellNum(); i++)
		{
			final Cell yearCell = headerRow.getCell(i);
			if (yearCell == null)
				continue;
			
			final String yearString = getCellStringValue(yearCell);
			final Integer year = parseInteger(yearString);
			if (year == null)
				continue;
			
			final Cell gdpPerCapitaCell = row.getCell(i);
			if (gdpPerCapitaCell == null)
				continue;
			
			final String gdpPerCapitaString = getCellStringValue(gdpPerCapitaCell);
			final Float gdpPerCapitaFloat = parseFloat(gdpPerCapitaString);
			if (gdpPerCapitaFloat == null)
				continue;
			
			final GDPPerCapita gdpPerCapita = GDPPerCapita
					.builder()
					.countryId(country.getId())
					.year(year)
					.gdpPerCapita(gdpPerCapitaFloat)
					.build();
			
			gdpPerCapitaList.add(gdpPerCapita);
		}
		
		return gdpPerCapitaList;
	}
}