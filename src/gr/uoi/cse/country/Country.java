package gr.uoi.cse.country;

import gr.uoi.cse.etl.ETL;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ETL(parserClass = CountryParser.class, parseDirectory = "resources/countries.csv", outputDirectory = "output/countries.txt")
public class Country
{
	private static final String LINE_DELIMETER = ";";
	private Integer id;
	private String iso;
	private String iso3;
	private Integer isoCode;
	private String fips;
	private String displayName;
	private String officialName;
	private String capitalName;
	private String continentName;
	private String currencyCode;
	private String currencyName;
	private Integer phone;
	private Integer regionCode;
	private String regionName;
	private Integer subRegionCode;
	private String subRegionName;
	private Integer intermediateRegionCode;
	private String intermediateRegionName;
	private String status;
	private String developmentStatus;
	private boolean sids;
	private boolean lldc;
	private boolean ldc;
	private Integer areaInSquaredKm;
	private Integer population;
	
	@Override
	public String toString()
	{
		String.format("", getId(), getIso(), getIso3());
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getId());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(getIso());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(getIso3());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(getIsoCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getFips());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getDisplayName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getOfficialName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getCapitalName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getContinentName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getCurrencyCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getCurrencyName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getPhone());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getRegionCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getRegionName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getSubRegionCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getSubRegionName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getIntermediateRegionCode());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getIntermediateRegionName());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getStatus());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getDevelopmentStatus());
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(isSids() ? 1 : 0);
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(isLldc() ? 1 : 0);
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(isLdc() ? 1 : 0);
		stringBuilder.append(LINE_DELIMETER);

		stringBuilder.append(getAreaInSquaredKm());
		stringBuilder.append(LINE_DELIMETER);
		
		stringBuilder.append(getPopulation());
		
		return stringBuilder.toString();
	}
}