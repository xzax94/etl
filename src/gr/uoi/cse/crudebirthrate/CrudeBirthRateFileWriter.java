package gr.uoi.cse.crudebirthrate;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class CrudeBirthRateFileWriter implements DiskFileWriter<CrudeBirthRate>
{
	@Override
	public void writeToDisk(List<CrudeBirthRate> crudeBirthRateList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final CrudeBirthRateToLineStringMapper crudeBirthRateToLineStringMapper = new CrudeBirthRateToLineStringMapper();
			
			for (final CrudeBirthRate crudeBirthRate : crudeBirthRateList)
			{
				String lineToWrite = crudeBirthRateToLineStringMapper.map(crudeBirthRate);
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