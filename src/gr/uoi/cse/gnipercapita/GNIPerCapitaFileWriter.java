package gr.uoi.cse.gnipercapita;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class GNIPerCapitaFileWriter implements DiskFileWriter<GNIPerCapita>
{
	@Override
	public void writeToDisk(List<GNIPerCapita> gniPerCapitaList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final GNIPerCapitaToLineStringMapper gniPerCapitaToLineStringMapper = new GNIPerCapitaToLineStringMapper();
			
			for (final GNIPerCapita gniPerCapita : gniPerCapitaList)
			{
				String lineToWrite = gniPerCapitaToLineStringMapper.map(gniPerCapita);
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