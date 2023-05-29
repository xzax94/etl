package gr.uoi.cse.netmigration;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ETL(parserClass = NetMigrationParser.class, parseDirectory = "resources/birth_death_growth_rates.csv", outputDirectory = "output/net_migrations.txt")
public final class NetMigration
{
	private Integer countryId;
	private Integer year;
	private Float netMigration;
	
	@Override
	public String toString()
	{
		return String.format("%d;%d;%s", getCountryId(), getYear(), getNetMigration());
	}
}