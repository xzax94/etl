package gr.uoi.cse.lifeexpectancybysex;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class LifeExpectancyBySexFileWriter implements DiskFileWriter<LifeExpectancyBySex>
{
	@Override
	public void writeToDisk(List<LifeExpectancyBySex> lifeExpectancyList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final LifeExpectancyBySexToLineStringMapper lifeExpectancyBySexToLineStringMapper = new LifeExpectancyBySexToLineStringMapper();
			
			for (final LifeExpectancyBySex lifeExpectancy : lifeExpectancyList)
			{
				String lineToWrite = lifeExpectancyBySexToLineStringMapper.map(lifeExpectancy);
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