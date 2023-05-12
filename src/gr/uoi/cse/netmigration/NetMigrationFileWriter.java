package gr.uoi.cse.netmigration;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import gr.uoi.cse.writer.DiskFileWriter;

public final class NetMigrationFileWriter implements DiskFileWriter<NetMigration>
{
	@Override
	public void writeToDisk(List<NetMigration> netMigrationList , String path) 
	{
		try(final FileWriter fileWriter = new FileWriter(path);
				final PrintWriter printWriter = new PrintWriter(fileWriter))
		{
			final NetMigrationToLineStringMapper netMigrationToLineStringMapper = new NetMigrationToLineStringMapper();
			
			for (final NetMigration netMigration : netMigrationList)
			{
				String lineToWrite = netMigrationToLineStringMapper.map(netMigration);
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