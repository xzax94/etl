package gr.uoi.cse.country;

import gr.uoi.cse.mapper.Mapper;

public final class LineStringToCountryMapper implements Mapper<String, Country>
{
	private static final String LINE_DELIMETER = ",";
	
	@Override
	public Country map(String line)
	{
		final String[] lineArray = line.split(LINE_DELIMETER);
		for (int i = 0; i < lineArray.length; i++) 
		{
            if (lineArray[i].isEmpty()) 
                lineArray[i] = null;
        }
		
		final String iso = lineArray[0];
		final String iso3 = lineArray[1];
		final Integer isoCode = parseInteger(lineArray[2]);
		final String fips = lineArray[3];
		final String displayName = lineArray[4];
		final String officialName = lineArray[5];
		final String capitalName = lineArray[6];
		final String continentName = lineArray[7];
		final String currencyCode = lineArray[8];
		final String currencyName = lineArray[9];
		final Integer phone = parseInteger(lineArray[10]);
		final Integer regionCode = parseInteger(lineArray[11]);
		final String regionName = lineArray[12];
		final Integer subRegionCode = parseInteger(lineArray[13]);
		final String subRegionName = lineArray[14];
		final Integer intermediateRegionCode = parseInteger(lineArray[15]);
		final String intermediateRegionName = lineArray[16];
		final String status = lineArray[17];
		final String developmentStatus = lineArray[18];
		final boolean sids = parseBoolean(lineArray[19]);
		final boolean lldc = parseBoolean(lineArray[20]);
		final boolean ldc = parseBoolean(lineArray[21]);
		final Integer areaInSquaredKm = parseInteger(lineArray[22]);
		final Integer population = parseInteger(lineArray[23]);
		
		final Country country = Country
				.builder()
				.iso(iso)
				.iso3(iso3)
				.isoCode(isoCode)
				.fips(fips)
				.displayName(displayName)
				.officialName(officialName)
				.capitalName(capitalName)
				.continentName(continentName)
				.currencyCode(currencyCode)
				.currencyName(currencyName)
				.phone(phone)
				.regionCode(regionCode)
				.regionName(regionName)
				.subRegionCode(subRegionCode)
				.subRegionName(subRegionName)
				.intermediateRegionCode(intermediateRegionCode)
				.intermediateRegionName(intermediateRegionName)
				.status(status)
				.developmentStatus(developmentStatus)
				.sids(sids)
				.lldc(lldc)
				.ldc(ldc)
				.areaInSquaredKm(areaInSquaredKm)
				.population(population)
				.build();
		
		return country;
	}
}