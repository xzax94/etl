package gr.uoi.cse.crudedeathrate;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class CrudeDeathRateFileWriter implements DiskFileWriter<CrudeDeathRate>
{
	@Override
	public void writeToDisk(List<CrudeDeathRate> crudeDeathRateList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final CrudeDeathRateToLineStringMapper crudeDeathRateToLineStringMapper = new CrudeDeathRateToLineStringMapper();
			
			for (final CrudeDeathRate crudeDeathRate : crudeDeathRateList)
			{
				String lineToWrite = crudeDeathRateToLineStringMapper.map(crudeDeathRate);
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