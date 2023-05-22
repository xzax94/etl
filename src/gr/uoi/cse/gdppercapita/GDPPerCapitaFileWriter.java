package gr.uoi.cse.gdppercapita;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class GDPPerCapitaFileWriter implements DiskFileWriter<GDPPerCapita>
{
	@Override
	public void writeToDisk(List<GDPPerCapita> gdpPerCapitaList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final GDPPerCapitaToLineStringMapper gdpPerCapitaToLineStringMapper = new GDPPerCapitaToLineStringMapper();
			
			for (final GDPPerCapita gdpPerCapita : gdpPerCapitaList)
			{
				String lineToWrite = gdpPerCapitaToLineStringMapper.map(gdpPerCapita);
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