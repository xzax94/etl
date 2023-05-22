package gr.uoi.cse.mortalityrate1to4;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class MortalityRate1To4FileWriter implements DiskFileWriter<MortalityRate1To4>
{
	@Override
	public void writeToDisk(List<MortalityRate1To4> mortalityRate1To4List , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final MortalityRate1To4ToLineStringMapper mortalityRate1To4ToLineStringMapper = new MortalityRate1To4ToLineStringMapper();
			
			for (final MortalityRate1To4 mortalityRate1To4 : mortalityRate1To4List)
			{
				String lineToWrite = mortalityRate1To4ToLineStringMapper.map(mortalityRate1To4);
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