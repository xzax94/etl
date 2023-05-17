package gr.uoi.cse.fertilityratetotal;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class FertilityRateTotalFileWriter implements DiskFileWriter<FertilityRateTotal>
{
	@Override
	public void writeToDisk(List<FertilityRateTotal> fertilityRateTotalList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final FertilityRateTotalToLineStringMapper fertilityRateTotalToLineStringMapper = new FertilityRateTotalToLineStringMapper();
			
			for (final FertilityRateTotal fertilityRateTotal : fertilityRateTotalList)
			{
				String lineToWrite = fertilityRateTotalToLineStringMapper.map(fertilityRateTotal);
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