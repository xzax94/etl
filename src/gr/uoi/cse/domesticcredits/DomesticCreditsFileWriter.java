package gr.uoi.cse.domesticcredits;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class DomesticCreditsFileWriter implements DiskFileWriter<DomesticCredits>
{
	@Override
	public void writeToDisk(List<DomesticCredits> domesticCreditsList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final DomesticCreditsToLineStringMapper domesticCreditsToLineStringMapper = new DomesticCreditsToLineStringMapper();
			
			for (final DomesticCredits domesticCredits : domesticCreditsList)
			{
				String lineToWrite = domesticCreditsToLineStringMapper.map(domesticCredits);
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