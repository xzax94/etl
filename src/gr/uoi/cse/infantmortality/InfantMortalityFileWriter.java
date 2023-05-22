package gr.uoi.cse.infantmortality;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class InfantMortalityFileWriter implements DiskFileWriter<InfantMortality>
{
	@Override
	public void writeToDisk(List<InfantMortality> infantMortalityList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final InfantMortalityToLineStringMapper infantMortalityToLineStringMapper = new InfantMortalityToLineStringMapper();
			
			for (final InfantMortality infantMortality : infantMortalityList)
			{
				String lineToWrite = infantMortalityToLineStringMapper.map(infantMortality);
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