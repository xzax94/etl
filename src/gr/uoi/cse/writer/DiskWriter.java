package gr.uoi.cse.writer;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public final class DiskWriter
{
	public void writeToDisk(List<?> entityList, String path)
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			for (final Object object : entityList)
			{
				final String lineToWrite = object.toString().replaceAll("null", "\\\\N");
				printWriter.println(lineToWrite);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
}