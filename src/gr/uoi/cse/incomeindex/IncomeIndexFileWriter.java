package gr.uoi.cse.incomeindex;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class IncomeIndexFileWriter implements DiskFileWriter<IncomeIndex>
{
	@Override
	public void writeToDisk(List<IncomeIndex> incomeIndexList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final IncomeIndexToLineStringMapper incomeIndexToLineStringMapper = new IncomeIndexToLineStringMapper();
			
			for (final IncomeIndex incomeIndex : incomeIndexList)
			{
				String lineToWrite = incomeIndexToLineStringMapper.map(incomeIndex);
				lineToWrite = lineToWrite.replaceAll("null", "\\\\N");
				printWriter.println(lineToWrite);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
}