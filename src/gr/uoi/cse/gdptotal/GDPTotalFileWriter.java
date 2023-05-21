package gr.uoi.cse.gdptotal;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class GDPTotalFileWriter implements DiskFileWriter<GDPTotal>
{
	@Override
	public void writeToDisk(List<GDPTotal> gdpTotalList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final GDPTotalToLineStringMapper gdpTotalToLineStringMapper = new GDPTotalToLineStringMapper();
			
			for (final GDPTotal gdpTotal : gdpTotalList)
			{
				String lineToWrite = gdpTotalToLineStringMapper.map(gdpTotal);
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