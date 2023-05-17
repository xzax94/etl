package gr.uoi.cse.midyearpopulation;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class MidyearPopulationFileWriter implements DiskFileWriter<MidyearPopulation>
{
	@Override
	public void writeToDisk(List<MidyearPopulation> midyearPopulationList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final MidyearPopulationToLineStringMapper midyearPopulationToLineStringMapper = new MidyearPopulationToLineStringMapper();
			
			for (final MidyearPopulation midyearPopulation : midyearPopulationList)
			{
				String lineToWrite = midyearPopulationToLineStringMapper.map(midyearPopulation);
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