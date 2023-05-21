package gr.uoi.cse.labourshareofgdp;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class LabourShareOfGDPFileWriter implements DiskFileWriter<LabourShareOfGDP>
{
	@Override
	public void writeToDisk(List<LabourShareOfGDP> labourShareList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final LabourShareOfGDPToLineStringMapper labourShareOfGDPToLineStringMapper = new LabourShareOfGDPToLineStringMapper();
			
			for (final LabourShareOfGDP incomeIndex : labourShareList)
			{
				String lineToWrite = labourShareOfGDPToLineStringMapper.map(incomeIndex);
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