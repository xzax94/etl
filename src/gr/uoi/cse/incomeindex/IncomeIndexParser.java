package gr.uoi.cse.incomeindex;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import gr.uoi.cse.parser.Parser;

public class IncomeIndexParser implements Parser<IncomeIndex>
{
	private static final String INCOME_INDEX_SHEET_NAME = "Income Index";
	
	@Override
	public List<IncomeIndex> parseDocument(String path) 
	{
		final List<IncomeIndex> incomeIndexList = new ArrayList<>();
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(INCOME_INDEX_SHEET_NAME);
			final XlsxRowToIncomeIndexMapper xlsxRowToIncomeIndexMapper = new XlsxRowToIncomeIndexMapper();
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<IncomeIndex> tempIncomeIndexList = xlsxRowToIncomeIndexMapper.map(row, firstRow);
				tempIncomeIndexList.forEach(incomeIndexList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return incomeIndexList;
	}
	
}