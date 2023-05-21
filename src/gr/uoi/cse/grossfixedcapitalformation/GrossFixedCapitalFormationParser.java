package gr.uoi.cse.grossfixedcapitalformation;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import gr.uoi.cse.parser.Parser;

public class GrossFixedCapitalFormationParser implements Parser<List<GrossFixedCapitalFormation>>
{
	private static final String GROSS_FIXED_CAPITAL_FORMATION_SHEET_NAME = "Gross fixed capital formation";
	
	@Override
	public List<GrossFixedCapitalFormation> parseDocument(String path) 
	{
		final List<GrossFixedCapitalFormation> grossFixedCapitalFormationList = new ArrayList<>();
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(GROSS_FIXED_CAPITAL_FORMATION_SHEET_NAME);
			final XlsxRowToGrossFixedCapitalFormationMapper xlsxRowToGrossFixedCapitalFormationMapper = new XlsxRowToGrossFixedCapitalFormationMapper();
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<GrossFixedCapitalFormation> tempGrossFixedCapitalFormationList = xlsxRowToGrossFixedCapitalFormationMapper.map(row, firstRow);
				tempGrossFixedCapitalFormationList.forEach(grossFixedCapitalFormationList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return grossFixedCapitalFormationList;
	}
	
}