package gr.uoi.cse.netmigration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class NetMigration
{
	private Integer countryId;
	private Integer year;
	private Float netMigration;
}