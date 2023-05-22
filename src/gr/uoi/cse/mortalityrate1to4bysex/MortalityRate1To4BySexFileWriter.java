package gr.uoi.cse.mortalityrate1to4bysex;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class MortalityRate1To4BySexFileWriter implements DiskFileWriter<MortalityRate1To4BySex>
{
	@Override
	public void writeToDisk(List<MortalityRate1To4BySex> mortalityRateList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final MortalityRate1To4BySexToLineStringMapper mortalityRate1To4BySexToLineStringMapper = new MortalityRate1To4BySexToLineStringMapper();
			
			for (final MortalityRate1To4BySex mortalityRate1To4BySex : mortalityRateList)
			{
				String lineToWrite = mortalityRate1To4BySexToLineStringMapper.map(mortalityRate1To4BySex);
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