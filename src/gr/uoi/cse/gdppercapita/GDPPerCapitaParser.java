package gr.uoi.cse.gdppercapita;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import gr.uoi.cse.parser.Parser;

public class GDPPerCapitaParser implements Parser<List<GDPPerCapita>>
{
	private static final String GDP_PER_CAPITA_SHEET_NAME = "GDP per capita";
	
	@Override
	public List<GDPPerCapita> parseDocument(String path) 
	{
		final List<GDPPerCapita> gdpPerCapitaList = new ArrayList<>();
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(GDP_PER_CAPITA_SHEET_NAME);
			final XlsxRowToGDPPerCapitaMapper xlsxRowToGDPPerCapitaMapper = new XlsxRowToGDPPerCapitaMapper();
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<GDPPerCapita> tempGDPPerCapitaList = xlsxRowToGDPPerCapitaMapper.map(row, firstRow);
				tempGDPPerCapitaList.forEach(gdpPerCapitaList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return gdpPerCapitaList;
	}
	
}