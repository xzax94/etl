package gr.uoi.cse.estimatedgni;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class EstimatedGNIFileWriter implements DiskFileWriter<EstimatedGNI>
{
	@Override
	public void writeToDisk(List<EstimatedGNI> estimatedGNIMaleList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final EstimatedGNIToLineStringMapper estimatedGNIMaleToLineStringMapper = new EstimatedGNIToLineStringMapper();
			
			for (final EstimatedGNI estimatedGNI : estimatedGNIMaleList)
			{
				String lineToWrite = estimatedGNIMaleToLineStringMapper.map(estimatedGNI);
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