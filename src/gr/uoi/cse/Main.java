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

public final class Main
{
	private static final String COUNTRY_PATH = "countries.csv";
	private static final String BIRTH_DEATH_GROWTH_RATES_PATH = "birth_death_growth_rates.csv";
	
	public static void main (String ... args)
	{
		loadCountries();
		loadCrudeBirthRates();
		loadCrudeDeathRates();
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
}