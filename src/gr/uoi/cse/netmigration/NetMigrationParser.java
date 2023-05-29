package gr.uoi.cse.netmigration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class NetMigrationParser implements Parser<NetMigration>
{
	@Override
	public List<NetMigration> parseDocument(String path)
	{
		final List<NetMigration> netMigrationList = new ArrayList<>();
		final LineStringToNetMigrationMapper lineStringToNetMigrationMapper = new LineStringToNetMigrationMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final NetMigration netMigration = lineStringToNetMigrationMapper.map(line);
				if (netMigration == null)
					continue;
				
				netMigrationList.add(netMigration);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return netMigrationList;
	}
}