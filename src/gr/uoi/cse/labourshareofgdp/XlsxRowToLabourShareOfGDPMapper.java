package gr.uoi.cse.labourshareofgdp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.mapper.XlsxRowMapper;

public final class XlsxRowToLabourShareOfGDPMapper implements XlsxRowMapper<List<LabourShareOfGDP>>
{
	private static final int COUNTRY_NAME_CELL_INDEX = 0;
	
	@Override
	public List<LabourShareOfGDP> map(Row row, Row headerRow) 
	{
		final Cell countryNameCell = row.getCell(COUNTRY_NAME_CELL_INDEX);
		final String countryName = getCellStringValue(countryNameCell);
		final Country country = CountryCache.getInstance().getCountryByName(countryName);
		if (country == null)
			return Collections.emptyList();
		
		final List<LabourShareOfGDP> labourShareList = new ArrayList<>();
		
		for (int i = 1; i <= headerRow.getLastCellNum(); i++)
		{
			final Cell yearCell = headerRow.getCell(i);
			if (yearCell == null)
				continue;
			
			final String yearString = getCellStringValue(yearCell);
			final Integer year = parseInteger(yearString);
			if (year == null)
				continue;
			
			final Cell labourShareCell = row.getCell(i);
			if (labourShareCell == null)
				continue;
			
			final String labourShareString = getCellStringValue(labourShareCell);
			final Float labourShareFloat = parseFloat(labourShareString);
			if (labourShareFloat == null)
				continue;
			
			final LabourShareOfGDP labourShare = LabourShareOfGDP
					.builder()
					.countryId(country.getId())
					.year(year)
					.labourShareOfGDP(labourShareFloat)
					.build();
			
			labourShareList.add(labourShare);
		}
		
		return labourShareList;
	}
}