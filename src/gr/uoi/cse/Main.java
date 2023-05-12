package gr.uoi.cse;

import java.util.List;

import gr.uoi.cse.country.Country;
import gr.uoi.cse.country.CountryCache;
import gr.uoi.cse.country.CountryFileWriter;
import gr.uoi.cse.country.CountryParser;
import gr.uoi.cse.crudebirthrate.CrudeBirthRate;
import gr.uoi.cse.crudebirthrate.CrudeBirthRateFileWriter;
import gr.uoi.cse.crudebirthrate.CrudeBirthRateParser;
import gr.uoi.cse.crudedeathrate.CrudeDeathRate;
import gr.uoi.cse.crudedeathrate.CrudeDeathRateFileWriter;
import gr.uoi.cse.crudedeathrate.CrudeDeathRateParser;
import gr.uoi.cse.growthrate.GrowthRate;
import gr.uoi.cse.growthrate.GrowthRateFileWriter;
import gr.uoi.cse.growthrate.GrowthRateParser;
import gr.uoi.cse.netmigration.NetMigration;
import gr.uoi.cse.netmigration.NetMigrationFileWriter;
import gr.uoi.cse.netmigration.NetMigrationParser;
import gr.uoi.cse.ratenaturalincrease.RateNaturalIncrease;
import gr.uoi.cse.ratenaturalincrease.RateNaturalIncreaseFileWriter;
import gr.uoi.cse.ratenaturalincrease.RateNaturalIncreaseParser;

public final class Main
{
	private static final String COUNTRY_PATH = "resources/countries.csv";
	private static final String BIRTH_DEATH_GROWTH_RATES_PATH = "resources/birth_death_growth_rates.csv";
	
	public static void main (String ... args)
	{
		loadCountries();
		loadCrudeBirthRates();
		loadCrudeDeathRates();
		loadNetMigrations();
		loadRateNaturalIncreases();
		parseGrowthRates();
	}
	
	private static final void loadCountries()
	{
		final CountryParser countryParser = new CountryParser();
		final List<Country> countryList = countryParser.parseDocument(COUNTRY_PATH);
		final CountryCache countryCache = CountryCache.getInstance();
		countryCache.addAll(countryList);
		final CountryFileWriter countryFileWriter = new CountryFileWriter();
		countryFileWriter.writeToDisk(countryList, "output/countries.txt");
	}
	
	private static final void loadCrudeBirthRates()
	{
		final CrudeBirthRateParser crudeBirthRateParser = new CrudeBirthRateParser();
		final List<CrudeBirthRate> crudeBirthRateList = crudeBirthRateParser.parseDocument(BIRTH_DEATH_GROWTH_RATES_PATH);
		final CrudeBirthRateFileWriter crudeBirthRateFileWriter = new CrudeBirthRateFileWriter();
		crudeBirthRateFileWriter.writeToDisk(crudeBirthRateList, "output/crude_birth_rates.txt");
	}
	
	private static final void loadCrudeDeathRates()
	{
		final CrudeDeathRateParser crudeDeathRateParser = new CrudeDeathRateParser();
		final List<CrudeDeathRate> crudeDeathRateList = crudeDeathRateParser.parseDocument(BIRTH_DEATH_GROWTH_RATES_PATH);
		final CrudeDeathRateFileWriter crudeDeathRateFileWriter = new CrudeDeathRateFileWriter();
		crudeDeathRateFileWriter.writeToDisk(crudeDeathRateList, "output/crude_death_rates.txt");
	}
	
	private static final void loadNetMigrations()
	{
		final NetMigrationParser netMigrationParser = new NetMigrationParser();
		final List<NetMigration> netMigrationList = netMigrationParser.parseDocument(BIRTH_DEATH_GROWTH_RATES_PATH);
		final NetMigrationFileWriter netMigrationFileWriter = new NetMigrationFileWriter();
		netMigrationFileWriter.writeToDisk(netMigrationList, "output/net_migrations.txt");
	}
	
	private static final void loadRateNaturalIncreases()
	{
		final RateNaturalIncreaseParser RateNaturalIncreaseParser = new RateNaturalIncreaseParser();
		final List<RateNaturalIncrease> rateNaturalIncreaseList = RateNaturalIncreaseParser.parseDocument(BIRTH_DEATH_GROWTH_RATES_PATH);
		final RateNaturalIncreaseFileWriter rateNaturalIncreaseFileWriter = new RateNaturalIncreaseFileWriter();
		rateNaturalIncreaseFileWriter.writeToDisk(rateNaturalIncreaseList, "output/rate_natural_increases.txt");
	}
	
	private static final void parseGrowthRates()
	{
		final GrowthRateParser growthRateParser = new GrowthRateParser();
		final List<GrowthRate> growthRateList = growthRateParser.parseDocument(BIRTH_DEATH_GROWTH_RATES_PATH);
		final GrowthRateFileWriter growthRateFileWriter = new GrowthRateFileWriter();
		growthRateFileWriter.writeToDisk(growthRateList, "output/growth_rates.txt");
	}
}