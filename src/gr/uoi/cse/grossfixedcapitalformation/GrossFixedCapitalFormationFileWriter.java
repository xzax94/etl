package gr.uoi.cse.grossfixedcapitalformation;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class GrossFixedCapitalFormationFileWriter implements DiskFileWriter<GrossFixedCapitalFormation>
{
	@Override
	public void writeToDisk(List<GrossFixedCapitalFormation> grossFixedCapitalFormationList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final GrossFixedCapitalFormationToLineStringMapper grossFixedCapitalFormationToLineStringMapper = new GrossFixedCapitalFormationToLineStringMapper();
			
			for (final GrossFixedCapitalFormation grossFixedCapitalFormation : grossFixedCapitalFormationList)
			{
				String lineToWrite = grossFixedCapitalFormationToLineStringMapper.map(grossFixedCapitalFormation);
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