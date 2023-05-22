package gr.uoi.cse.lifeexpectancy;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class LifeExpectancyFileWriter implements DiskFileWriter<LifeExpectancy>
{
	@Override
	public void writeToDisk(List<LifeExpectancy> lifeExpectancyList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final LifeExpectancyToLineStringMapper lifeExpectancyToLineStringMapper = new LifeExpectancyToLineStringMapper();
			
			for (final LifeExpectancy lifeExpectancy : lifeExpectancyList)
			{
				String lineToWrite = lifeExpectancyToLineStringMapper.map(lifeExpectancy);
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