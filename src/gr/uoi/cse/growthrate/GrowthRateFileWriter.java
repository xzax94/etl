package gr.uoi.cse.growthrate;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class GrowthRateFileWriter implements DiskFileWriter<GrowthRate>
{
	@Override
	public void writeToDisk(List<GrowthRate> growthRateList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final GrowthRateToLineStringMapper growthRateToLineStringMapper = new GrowthRateToLineStringMapper();
			
			for (final GrowthRate growthRate : growthRateList)
			{
				String lineToWrite = growthRateToLineStringMapper.map(growthRate);
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