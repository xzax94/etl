package gr.uoi.cse.gnipercapita;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import gr.uoi.cse.parser.Parser;

public class GNIPerCapitaParser implements Parser<List<GNIPerCapita>>
{
	private static final String GNI_PER_CAPITA_SHEET_NAME = "GNI per capita";
	
	@Override
	public List<GNIPerCapita> parseDocument(String path) 
	{
		final List<GNIPerCapita> gniPerCapitaList = new ArrayList<>();
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(GNI_PER_CAPITA_SHEET_NAME);
			final XlsxRowToGNIPerCapitaMapper xlsxRowToGNIPerCapitaMapper = new XlsxRowToGNIPerCapitaMapper();
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<GNIPerCapita> tempGNIPerCapitaList = xlsxRowToGNIPerCapitaMapper.map(row, firstRow);
				tempGNIPerCapitaList.forEach(gniPerCapitaList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return gniPerCapitaList;
	}
	
}