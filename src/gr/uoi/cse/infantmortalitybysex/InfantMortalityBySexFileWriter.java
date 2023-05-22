package gr.uoi.cse.infantmortalitybysex;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class InfantMortalityBySexFileWriter implements DiskFileWriter<InfantMortalityBySex>
{
	@Override
	public void writeToDisk(List<InfantMortalityBySex> infantMortalityList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final InfantMortalityBySexToLineStringMapper infantMortalityBySexToLineStringMapper = new InfantMortalityBySexToLineStringMapper();
			
			for (final InfantMortalityBySex infantMortality : infantMortalityList)
			{
				String lineToWrite = infantMortalityBySexToLineStringMapper.map(infantMortality);
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