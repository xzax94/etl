package gr.uoi.cse.ratenaturalincrease;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class RateNaturalIncreaseFileWriter implements DiskFileWriter<RateNaturalIncrease>
{
	@Override
	public void writeToDisk(List<RateNaturalIncrease> rateNaturalIncreaseList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final RateNaturalIncreaseToLineStringMapper rateNaturalIncreaseToLineStringMapper = new RateNaturalIncreaseToLineStringMapper();
			
			for (final RateNaturalIncrease rateNaturalIncrease : rateNaturalIncreaseList)
			{
				String lineToWrite = rateNaturalIncreaseToLineStringMapper.map(rateNaturalIncrease);
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