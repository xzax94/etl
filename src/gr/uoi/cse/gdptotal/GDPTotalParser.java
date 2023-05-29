package gr.uoi.cse.gdptotal;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import gr.uoi.cse.parser.Parser;

public class GDPTotalParser implements Parser<GDPTotal>
{
	private static final String GDP_TOTAL_SHEET_NAME = "GDP total";
	
	@Override
	public List<GDPTotal> parseDocument(String path) 
	{
		final List<GDPTotal> gdpTotalList = new ArrayList<>();
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(GDP_TOTAL_SHEET_NAME);
			final XlsxRowToGDPTotalMapper xlsxRowToGDPTotalMapper = new XlsxRowToGDPTotalMapper();
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<GDPTotal> tempGDPTotalList = xlsxRowToGDPTotalMapper.map(row, firstRow);
				tempGDPTotalList.forEach(gdpTotalList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return gdpTotalList;
	}
	
}