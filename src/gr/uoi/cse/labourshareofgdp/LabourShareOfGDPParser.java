package gr.uoi.cse.labourshareofgdp;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import gr.uoi.cse.parser.Parser;

public final class LabourShareOfGDPParser implements Parser<LabourShareOfGDP>
{
	private static final String LABOUR_SHARE_SHEET_NAME = "Labour share of GDP";
	
	@Override
	public List<LabourShareOfGDP> parseDocument(String path) 
	{
		final List<LabourShareOfGDP> labourShareOfGDPList = new ArrayList<>();
		
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(LABOUR_SHARE_SHEET_NAME);
			final XlsxRowToLabourShareOfGDPMapper xlsxRowToLabourShareOfGDPMapper = new XlsxRowToLabourShareOfGDPMapper();
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<LabourShareOfGDP> tempLabourShareOfGDPList = xlsxRowToLabourShareOfGDPMapper.map(row, firstRow);
				tempLabourShareOfGDPList.forEach(labourShareOfGDPList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		return labourShareOfGDPList;
	}
	
}