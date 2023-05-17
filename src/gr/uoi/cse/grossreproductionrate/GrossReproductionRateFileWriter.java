package gr.uoi.cse.grossreproductionrate;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class GrossReproductionRateFileWriter implements DiskFileWriter<GrossReproductionRate>
{
	@Override
	public void writeToDisk(List<GrossReproductionRate> grossReproductionRateList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final GrossReproductionRateToLineStringMapper grossReproductionRateToLineStringMapper = new GrossReproductionRateToLineStringMapper();
			
			for (final GrossReproductionRate grossReproductionRate : grossReproductionRateList)
			{
				String lineToWrite = grossReproductionRateToLineStringMapper.map(grossReproductionRate);
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