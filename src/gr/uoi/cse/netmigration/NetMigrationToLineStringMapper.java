package gr.uoi.cse.netmigration;

import gr.uoi.cse.mapper.Mapper;

public final class NetMigrationToLineStringMapper implements Mapper<NetMigration, String>
{
	private static final String LINE_DELIMETER = ";";
	
	@Override
	public String map(NetMigration netMigration)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(netMigration.getCountryId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(netMigration.getYear());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(netMigration.getNetMigration());
		
		return stringBuilder.toString();
	}
}