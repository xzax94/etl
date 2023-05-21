package gr.uoi.cse.mapper;

import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

@FunctionalInterface
public interface XlsxRowMapper<T>
{
	T map(Row row, Row headerRow);
	
	default String getCellStringValue(Cell cell) 
	{
		switch (cell.getCellType()) 
		{
		case STRING: 
			return cell.getStringCellValue();
		case NUMERIC : 
		{
			final double numericValue = cell.getNumericCellValue();
			if (numericValue == Math.floor(numericValue)) 
				return new DecimalFormat("#").format(numericValue);

			return String.valueOf(numericValue);
		}
		case BOOLEAN :	
			return String.valueOf(cell.getBooleanCellValue());
		default :
			return null;
		}
	}
	
	default Integer parseInteger(String string)
	{
		try
		{
			return Integer.parseInt(string);
		}
		catch (final Exception e)
		{
			return null;
		}
	}
	
	default boolean parseBoolean(String string)
	{
		try
		{
			return Boolean.parseBoolean(string);
		}
		catch (final Exception e)
		{
			return false;
		}
	}
	
	default Float parseFloat(String string)
	{
		try
		{
			return Float.parseFloat(string);
		}
		catch (final Exception e)
		{
			return null;
		}
	}
}