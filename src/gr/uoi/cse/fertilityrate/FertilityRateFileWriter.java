package gr.uoi.cse.fertilityrate;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class FertilityRateFileWriter implements DiskFileWriter<FertilityRate>
{
	@Override
	public void writeToDisk(List<FertilityRate> fertilityRateList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final FertilityRateToLineStringMapper fertilityRateToLineStringMapper = new FertilityRateToLineStringMapper();
			
			for (final FertilityRate fertilityRate : fertilityRateList)
			{
				String lineToWrite = fertilityRateToLineStringMapper.map(fertilityRate);
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