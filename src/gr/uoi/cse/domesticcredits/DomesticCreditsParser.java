package gr.uoi.cse.domesticcredits;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import gr.uoi.cse.parser.Parser;

public class DomesticCreditsParser implements Parser<DomesticCredits>
{
	private static final String INCOME_INDEX_SHEET_NAME = "Domestic credits";
	
	@Override
	public List<DomesticCredits> parseDocument(String path) 
	{
		final List<DomesticCredits> domesticCreditsList = new ArrayList<>();
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(INCOME_INDEX_SHEET_NAME);
			final XlsxRowToDomesticCreditsMapper xlsxRowToDomesticCreditsMapper = new XlsxRowToDomesticCreditsMapper();
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<DomesticCredits> tempDomesticCreditsList = xlsxRowToDomesticCreditsMapper.map(row, firstRow);
				tempDomesticCreditsList.forEach(domesticCreditsList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return domesticCreditsList;
	}
	
}