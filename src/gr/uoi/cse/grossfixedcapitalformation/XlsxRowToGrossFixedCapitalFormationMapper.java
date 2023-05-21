package gr.uoi.cse.grossfixedcapitalformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.XlsxRowMapper;

public final class XlsxRowToGrossFixedCapitalFormationMapper implements XlsxRowMapper<List<GrossFixedCapitalFormation>>
{
	private static final int COUNTRY_NAME_CELL_INDEX = 0;
	
	@Override
	public List<GrossFixedCapitalFormation> map(Row row, Row headerRow) 
	{
		final Cell countryNameCell = row.getCell(COUNTRY_NAME_CELL_INDEX);
		final String countryName = getCellStringValue(countryNameCell);
		final Country country = CountryCache.getInstance().getCountryByName(countryName);
		if (country == null)
			return Collections.emptyList();
		
		final List<GrossFixedCapitalFormation> grossFixedCapitalFormationList = new ArrayList<>();
		
		for (int i = 1; i <= headerRow.getLastCellNum(); i++)
		{
			final Cell yearCell = headerRow.getCell(i);
			if (yearCell == null)
				continue;
			
			final String yearString = getCellStringValue(yearCell);
			final Integer year = parseInteger(yearString);
			if (year == null)
				continue;
			
			final Cell grossFixedCapitalFormationCell = row.getCell(i);
			if (grossFixedCapitalFormationCell == null)
				continue;
			
			final String grossFixedCapitalFormationString = getCellStringValue(grossFixedCapitalFormationCell);
			final Float grossFixedCapitalFormationFloat = parseFloat(grossFixedCapitalFormationString);
			if (grossFixedCapitalFormationFloat == null)
				continue;
			
			final GrossFixedCapitalFormation grossFixedCapitalFormation = GrossFixedCapitalFormation
					.builder()
					.countryId(country.getId())
					.year(year)
					.grossFixedCapitalFormation(grossFixedCapitalFormationFloat)
					.build();
			
			grossFixedCapitalFormationList.add(grossFixedCapitalFormation);
		}
		
		return grossFixedCapitalFormationList;
	}
}