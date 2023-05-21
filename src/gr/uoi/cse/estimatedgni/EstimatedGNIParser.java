package gr.uoi.cse.estimatedgni;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import gr.uoi.cse.parser.Parser;
import gr.uoi.cse.sex.Sex;

public class EstimatedGNIParser implements Parser<List<EstimatedGNI>>
{
	private static final String ESTIMATED_GNI_MALE_SHEET_NAME = "Estimated GNI male";
	private static final String ESTIMATED_GNI_FEMALE_SHEET_NAME = "Estimated GNI female";
	
	@Override
	public List<EstimatedGNI> parseDocument(String path) 
	{
		final List<EstimatedGNI> estimatedGNIMaleList = parseMaleList(path);
		final List<EstimatedGNI> estimatedGNIFemaleList = parseFemaleList(path);
		return Stream
				.concat(estimatedGNIMaleList.stream(), estimatedGNIFemaleList.stream())
                .collect(Collectors.toList());
	}
	
	private final List<EstimatedGNI> parseMaleList(String path)
	{
		final List<EstimatedGNI> estimatedGNIMaleList = new ArrayList<>();
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(ESTIMATED_GNI_MALE_SHEET_NAME);
			final XlsxRowToEstimatedGNIMapper xlsxRowToEstimatedGNIMapper = new XlsxRowToEstimatedGNIMapper(Sex.MALE);
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<EstimatedGNI> tempestimatedGNIMaleList = xlsxRowToEstimatedGNIMapper.map(row, firstRow);
				tempestimatedGNIMaleList.forEach(estimatedGNIMaleList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		return estimatedGNIMaleList;
	}
	
	private final List<EstimatedGNI> parseFemaleList(String path)
	{
		final List<EstimatedGNI> estimatedGNIFemaleList = new ArrayList<>();
		try(final FileInputStream file = new FileInputStream(path);
				final Workbook workbook = WorkbookFactory.create(file))
		{
			final Sheet sheet = workbook.getSheet(ESTIMATED_GNI_FEMALE_SHEET_NAME);
			final XlsxRowToEstimatedGNIMapper xlsxRowToEstimatedGNIMapper = new XlsxRowToEstimatedGNIMapper(Sex.FEMALE);
			final Row firstRow = sheet.getRow(0);
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++)
			{
				final Row row = sheet.getRow(i);
				final List<EstimatedGNI> tempestimatedGNIFemaleList = xlsxRowToEstimatedGNIMapper.map(row, firstRow);
				tempestimatedGNIFemaleList.forEach(estimatedGNIFemaleList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		return estimatedGNIFemaleList;
	}
	
}