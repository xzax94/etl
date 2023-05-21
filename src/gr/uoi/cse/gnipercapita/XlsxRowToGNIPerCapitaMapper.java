package gr.uoi.cse.gnipercapita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.XlsxRowMapper;

public final class XlsxRowToGNIPerCapitaMapper implements XlsxRowMapper<List<GNIPerCapita>>
{
	private static final int COUNTRY_NAME_CELL_INDEX = 0;
	
	@Override
	public List<GNIPerCapita> map(Row row, Row headerRow) 
	{
		final Cell countryNameCell = row.getCell(COUNTRY_NAME_CELL_INDEX);
		final String countryName = getCellStringValue(countryNameCell);
		final Country country = CountryCache.getInstance().getCountryByName(countryName);
		if (country == null)
			return Collections.emptyList();
		
		final List<GNIPerCapita> gniPerCapitaList = new ArrayList<>();
		
		for (int i = 1; i <= headerRow.getLastCellNum(); i++)
		{
			final Cell yearCell = headerRow.getCell(i);
			if (yearCell == null)
				continue;
			
			final String yearString = getCellStringValue(yearCell);
			final Integer year = parseInteger(yearString);
			if (year == null)
				continue;
			
			final Cell gniPerCapitaCell = row.getCell(i);
			if (gniPerCapitaCell == null)
				continue;
			
			final String gniPerCapitaString = getCellStringValue(gniPerCapitaCell);
			final Float gniPerCapitaFloat = parseFloat(gniPerCapitaString);
			if (gniPerCapitaFloat == null)
				continue;
			
			final GNIPerCapita gniPerCapita = GNIPerCapita
					.builder()
					.countryId(country.getId())
					.year(year)
					.gniPerCapita(gniPerCapitaFloat)
					.build();
			
			gniPerCapitaList.add(gniPerCapita);
		}
		
		return gniPerCapitaList;
	}
}