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
import gr.uoi.cse.domesticcredits.DomesticCredits;
import gr.uoi.cse.domesticcredits.DomesticCreditsFileWriter;
import gr.uoi.cse.domesticcredits.DomesticCreditsParser;
import gr.uoi.cse.estimatedgni.EstimatedGNI;
import gr.uoi.cse.estimatedgni.EstimatedGNIFileWriter;
import gr.uoi.cse.estimatedgni.EstimatedGNIParser;
import gr.uoi.cse.fertilityrate.FertilityRate;
import gr.uoi.cse.fertilityrate.FertilityRateFileWriter;
import gr.uoi.cse.fertilityrate.FertilityRateParser;
import gr.uoi.cse.fertilityratetotal.FertilityRateTotal;
import gr.uoi.cse.fertilityratetotal.FertilityRateTotalFileWriter;
import gr.uoi.cse.fertilityratetotal.FertilityRateTotalParser;
import gr.uoi.cse.gdptotal.GDPTotal;
import gr.uoi.cse.gdptotal.GDPTotalFileWriter;
import gr.uoi.cse.gdptotal.GDPTotalParser;
import gr.uoi.cse.gnipercapita.GNIPerCapita;
import gr.uoi.cse.gnipercapita.GNIPerCapitaFileWriter;
import gr.uoi.cse.gnipercapita.GNIPerCapitaParser;
import gr.uoi.cse.grossfixedcapitalformation.GrossFixedCapitalFormation;
import gr.uoi.cse.grossfixedcapitalformation.GrossFixedCapitalFormationFileWriter;
import gr.uoi.cse.grossfixedcapitalformation.GrossFixedCapitalFormationParser;
import gr.uoi.cse.grossreproductionrate.GrossReproductionRate;
import gr.uoi.cse.grossreproductionrate.GrossReproductionRateFileWriter;
import gr.uoi.cse.grossreproductionrate.GrossReproductionRateParser;
import gr.uoi.cse.growthrate.GrowthRate;
import gr.uoi.cse.growthrate.GrowthRateFileWriter;
import gr.uoi.cse.growthrate.GrowthRateParser;
import gr.uoi.cse.incomeindex.IncomeIndex;
import gr.uoi.cse.incomeindex.IncomeIndexFileWriter;
import gr.uoi.cse.incomeindex.IncomeIndexParser;
import gr.uoi.cse.infantmortality.InfantMortality;
import gr.uoi.cse.infantmortality.InfantMortalityFileWriter;
import gr.uoi.cse.infantmortality.InfantMortalityParser;
import gr.uoi.cse.infantmortalitybysex.InfantMortalityBySex;
import gr.uoi.cse.infantmortalitybysex.InfantMortalityBySexFileWriter;
import gr.uoi.cse.infantmortalitybysex.InfantMortalityBySexParser;
import gr.uoi.cse.labourshareofgdp.LabourShareOfGDP;
import gr.uoi.cse.labourshareofgdp.LabourShareOfGDPFileWriter;
import gr.uoi.cse.labourshareofgdp.LabourShareOfGDPParser;
import gr.uoi.cse.midyearpopulation.MidyearPopulation;
import gr.uoi.cse.midyearpopulation.MidyearPopulationFileWriter;
import gr.uoi.cse.midyearpopulation.MidyearPopulationParser;
import gr.uoi.cse.midyearpopulationbyagesex.MidYearPopulationByAgeSex;
import gr.uoi.cse.midyearpopulationbyagesex.MidYearPopulationByAgeSexFileWriter;
import gr.uoi.cse.midyearpopulationbyagesex.MidYearPopulationByAgeSexParser;
import gr.uoi.cse.netmigration.NetMigration;
import gr.uoi.cse.netmigration.NetMigrationFileWriter;
import gr.uoi.cse.netmigration.NetMigrationParser;
import gr.uoi.cse.ratenaturalincrease.RateNaturalIncrease;
import gr.uoi.cse.ratenaturalincrease.RateNaturalIncreaseFileWriter;
import gr.uoi.cse.ratenaturalincrease.RateNaturalIncreaseParser;
import gr.uoi.cse.sexratioatbirth.SexRatioAtBirth;
import gr.uoi.cse.sexratioatbirth.SexRatioAtBirthFileWriter;
import gr.uoi.cse.sexratioatbirth.SexRatioAtBirthParser;

public final class Main
{
	private static final String COUNTRY_PATH = "resources/countries.csv";
	private static final String BIRTH_DEATH_GROWTH_RATES_PATH = "resources/birth_death_growth_rates.csv";
	private static final String AGE_SPECIFIC_FERTILITY_RATES_PATH = "resources/age_specific_fertility_rates.csv";
	private static final String MIDYEAR_POPULATION_PATH = "resources/midyear_population.csv";
	private static final String INCOME_BY_COUNTRY_PATH = "resources/Income by Country.xlsx";
	private static final String MIDYEAR_POPULATION_BY_AGE_SEX_PATH = "resources/midyear_population_age_sex.csv";
	private static final String MORTALITY_LIFE_EXPECTANCY_PATH = "resources/mortality_life_expectancy.csv";
	
	public static void main (String ... args)
	{
		loadCountries();
//		loadCrudeBirthRates();
//		loadCrudeDeathRates();
//		loadNetMigrations();
//		loadRateNaturalIncreases();
//		parseGrowthRates();
//		parseFertilityRates();
//		parseFertilityRateTotal();
//		parseGrossReproductionRates();
//		parseSexRatioAtBirth();
//		parseMidYearPopulation();
//		parseIncomeIndex();
//		loadLabourShareOfGDP();
//		loadGrossFixedCapitalFormation();
//		loadGDPTotal();
//		loadGNIPerCapita();
//		loadEstimatedGNI();
//		loadDomesticCredits();
//		loadMidYearPopulationByAgeSex();
//		loadInfantMortality();
		loadInfantMortalityBySex();
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
	
	private static final void parseFertilityRates()
	{
		final FertilityRateParser fertilityRateParser = new FertilityRateParser();
		final List<FertilityRate> fertilityRateList = fertilityRateParser.parseDocument(AGE_SPECIFIC_FERTILITY_RATES_PATH);
		final FertilityRateFileWriter fertilityRateFileWriter = new FertilityRateFileWriter();
		fertilityRateFileWriter.writeToDisk(fertilityRateList, "output/fertility_rates.txt");
	}
	
	private static final void parseFertilityRateTotal()
	{
		final FertilityRateTotalParser fertilityRateTotalParser = new FertilityRateTotalParser();
		final List<FertilityRateTotal> fertilityRateTotalList = fertilityRateTotalParser.parseDocument(AGE_SPECIFIC_FERTILITY_RATES_PATH);
		final FertilityRateTotalFileWriter fertilityRateTotalFileWriter = new FertilityRateTotalFileWriter();
		fertilityRateTotalFileWriter.writeToDisk(fertilityRateTotalList, "output/fertility_total_rates.txt");
	}
	
	private static final void parseGrossReproductionRates()
	{
		final GrossReproductionRateParser grossReproductionRateParser = new GrossReproductionRateParser();
		final List<GrossReproductionRate> grossReproductionRateList = grossReproductionRateParser.parseDocument(AGE_SPECIFIC_FERTILITY_RATES_PATH);
		final GrossReproductionRateFileWriter grossReproductionRateFileWriter = new GrossReproductionRateFileWriter();
		grossReproductionRateFileWriter.writeToDisk(grossReproductionRateList, "output/gross_reproduction_rates.txt");
	}
	
	private static final void parseSexRatioAtBirth()
	{
		final SexRatioAtBirthParser sexRatioAtBirthParser = new SexRatioAtBirthParser();
		final List<SexRatioAtBirth> sexRatioAtBirthList = sexRatioAtBirthParser.parseDocument(AGE_SPECIFIC_FERTILITY_RATES_PATH);
		final SexRatioAtBirthFileWriter sexRatioAtBirthFileWriter = new SexRatioAtBirthFileWriter();
		sexRatioAtBirthFileWriter.writeToDisk(sexRatioAtBirthList, "output/sex_ratio_at_birth.txt");
	}
	
	private static final void parseMidYearPopulation()
	{
		final MidyearPopulationParser midyearPopulationParser = new MidyearPopulationParser();
		final List<MidyearPopulation> midyearPopulationList = midyearPopulationParser.parseDocument(MIDYEAR_POPULATION_PATH);
		final MidyearPopulationFileWriter midyearPopulationFileWriter = new MidyearPopulationFileWriter();
		midyearPopulationFileWriter.writeToDisk(midyearPopulationList, "output/midyear_population.txt");
	}
	
	private static final void parseIncomeIndex()
	{
		final IncomeIndexParser incomeIndexParser = new IncomeIndexParser();
		final List<IncomeIndex> incomeIndexList = incomeIndexParser.parseDocument(INCOME_BY_COUNTRY_PATH);
		final IncomeIndexFileWriter incomeIndexFileWriter = new IncomeIndexFileWriter();
		incomeIndexFileWriter.writeToDisk(incomeIndexList, "output/income_index.txt");
	}
	
	private static final void loadLabourShareOfGDP()
	{
		final LabourShareOfGDPParser labourShareOfGDPParser = new LabourShareOfGDPParser();
		final List<LabourShareOfGDP> labourShareOfGDPList = labourShareOfGDPParser.parseDocument(INCOME_BY_COUNTRY_PATH);
		final LabourShareOfGDPFileWriter labourShareOfGDPFileWriter = new LabourShareOfGDPFileWriter();
		labourShareOfGDPFileWriter.writeToDisk(labourShareOfGDPList, "output/labour_share_of_gdp.txt");
	}
	
	private static final void loadGrossFixedCapitalFormation()
	{
		final GrossFixedCapitalFormationParser grossFixedCapitalFormationParser = new GrossFixedCapitalFormationParser();
		final List<GrossFixedCapitalFormation> grossFixedCapitalFormationList = grossFixedCapitalFormationParser.parseDocument(INCOME_BY_COUNTRY_PATH);
		final GrossFixedCapitalFormationFileWriter grossFixedCapitalFormationFileWriter = new GrossFixedCapitalFormationFileWriter();
		grossFixedCapitalFormationFileWriter.writeToDisk(grossFixedCapitalFormationList, "output/gross_fixed_capital_formation.txt");
	}
	
	private static final void loadGDPTotal()
	{
		final GDPTotalParser gdpTotalParser = new GDPTotalParser();
		final List<GDPTotal> gdpTotalList = gdpTotalParser.parseDocument(INCOME_BY_COUNTRY_PATH);
		final GDPTotalFileWriter gdpTotalFileWriter = new GDPTotalFileWriter();
		gdpTotalFileWriter.writeToDisk(gdpTotalList, "output/gdp_total.txt");
	}
	
	private static final void loadGNIPerCapita()
	{
		final GNIPerCapitaParser gniPerCapitaParser = new GNIPerCapitaParser();
		final List<GNIPerCapita> gniPerCapitaList = gniPerCapitaParser.parseDocument(INCOME_BY_COUNTRY_PATH);
		final GNIPerCapitaFileWriter gniPerCapitaFileWriter = new GNIPerCapitaFileWriter();
		gniPerCapitaFileWriter.writeToDisk(gniPerCapitaList, "output/gni_per_capita.txt");
	}
	
	private static final void loadEstimatedGNI()
	{
		final EstimatedGNIParser estimatedGNIParser = new EstimatedGNIParser();
		final List<EstimatedGNI> estimatedGNIList = estimatedGNIParser.parseDocument(INCOME_BY_COUNTRY_PATH);
		final EstimatedGNIFileWriter estimatedGNIFileWriter = new EstimatedGNIFileWriter();
		estimatedGNIFileWriter.writeToDisk(estimatedGNIList, "output/estimated_gni.txt");
	}
	
	private static final void loadDomesticCredits() 
	{
		final DomesticCreditsParser domestisCreditsParser = new DomesticCreditsParser();
		final List<DomesticCredits> domestisCreditsList = domestisCreditsParser.parseDocument(INCOME_BY_COUNTRY_PATH);
		final DomesticCreditsFileWriter domesticCreditsFileWriter = new DomesticCreditsFileWriter();
		domesticCreditsFileWriter.writeToDisk(domestisCreditsList, "output/domestic_credits.txt");
	}
	
	private static final void loadMidYearPopulationByAgeSex()
	{
		final MidYearPopulationByAgeSexParser midYearPopulationByAgeSexParser = new MidYearPopulationByAgeSexParser();
		final List<MidYearPopulationByAgeSex> midYearPopulationByAgeSexList = midYearPopulationByAgeSexParser.parseDocument(MIDYEAR_POPULATION_BY_AGE_SEX_PATH);
		final MidYearPopulationByAgeSexFileWriter midYearPopulationByAgeSexFileWriter = new MidYearPopulationByAgeSexFileWriter();
		midYearPopulationByAgeSexFileWriter.writeToDisk(midYearPopulationByAgeSexList, "output/midyear_population_by_age_sex.txt");
	}
	
	private static final void loadInfantMortality()
	{
		final InfantMortalityParser infantMortalityParser = new InfantMortalityParser();
		final List<InfantMortality> infantMortalityList = infantMortalityParser.parseDocument(MORTALITY_LIFE_EXPECTANCY_PATH);
		final InfantMortalityFileWriter infantMortalityFileWriter = new InfantMortalityFileWriter();
		infantMortalityFileWriter.writeToDisk(infantMortalityList, "output/infant_mortality.txt");
	}
	
	private static final void loadInfantMortalityBySex()
	{
		final InfantMortalityBySexParser infantMortalityBySexParser = new InfantMortalityBySexParser();
		final List<InfantMortalityBySex> infantMortalityBySexList = infantMortalityBySexParser.parseDocument(MORTALITY_LIFE_EXPECTANCY_PATH);
		final InfantMortalityBySexFileWriter infantMortalityBySexFileWriter = new InfantMortalityBySexFileWriter();
		infantMortalityBySexFileWriter.writeToDisk(infantMortalityBySexList, "output/infant_mortality_by_sex.txt");
	}
}