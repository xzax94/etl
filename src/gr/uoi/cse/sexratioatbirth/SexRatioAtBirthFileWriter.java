package gr.uoi.cse.sexratioatbirth;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class SexRatioAtBirthFileWriter implements DiskFileWriter<SexRatioAtBirth>
{
	@Override
	public void writeToDisk(List<SexRatioAtBirth> sexRatioAtBirthList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final SexRatioAtBirthToLineStringMapper sexRatioAtBirthToLineStringMapper = new SexRatioAtBirthToLineStringMapper();
			
			for (final SexRatioAtBirth sexRatioAtBirth : sexRatioAtBirthList)
			{
				String lineToWrite = sexRatioAtBirthToLineStringMapper.map(sexRatioAtBirth);
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