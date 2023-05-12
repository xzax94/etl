package gr.uoi.cse.country;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class CountryFileWriter implements DiskFileWriter<Country>
{
	@Override
	public void writeToDisk(List<Country> countryList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final CountryToLineStringMapper countryToLineStringMapper = new CountryToLineStringMapper();
			
			for (final Country country : countryList)
			{
				String lineToWrite = countryToLineStringMapper.map(country);
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