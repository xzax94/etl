package gr.uoi.cse.mortalityrateunder5bysex;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class MortalityRateUnder5BySexFileWriter implements DiskFileWriter<MortalityRateUnder5BySex>
{
	@Override
	public void writeToDisk(List<MortalityRateUnder5BySex> mortalityRateList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final MortalityRateUnder5BySexToLineStringMapper mortalityRateUnder5BySexToLineStringMapper = new MortalityRateUnder5BySexToLineStringMapper();
			
			for (final MortalityRateUnder5BySex mortalityRateUnder5BySex : mortalityRateList)
			{
				String lineToWrite = mortalityRateUnder5BySexToLineStringMapper.map(mortalityRateUnder5BySex);
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