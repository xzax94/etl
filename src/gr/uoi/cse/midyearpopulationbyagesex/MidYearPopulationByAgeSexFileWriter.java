package gr.uoi.cse.midyearpopulationbyagesex;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class MidYearPopulationByAgeSexFileWriter implements DiskFileWriter<MidYearPopulationByAgeSex>
{
	@Override
	public void writeToDisk(List<MidYearPopulationByAgeSex> midyearPopulationList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final MidYearPopulationByAgeSexToLineStringMapper midYearPopulationByAgeSexToLineStringMapper = new MidYearPopulationByAgeSexToLineStringMapper();
			
			for (final MidYearPopulationByAgeSex midyearPopulation : midyearPopulationList)
			{
				String lineToWrite = midYearPopulationByAgeSexToLineStringMapper.map(midyearPopulation);
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