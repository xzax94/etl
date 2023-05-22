package gr.uoi.cse.mortalityrateunder5;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class MortalityRateUnder5FileWriter implements DiskFileWriter<MortalityRateUnder5>
{
	@Override
	public void writeToDisk(List<MortalityRateUnder5> mortalityRateUnder5List , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final MortalityRateUnder5ToLineStringMapper mortalityRateUnder5ToLineStringMapper = new MortalityRateUnder5ToLineStringMapper();
			
			for (final MortalityRateUnder5 mortalityRateUnder5 : mortalityRateUnder5List)
			{
				String lineToWrite = mortalityRateUnder5ToLineStringMapper.map(mortalityRateUnder5);
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