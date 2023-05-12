package gr.uoi.cse.country;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.idfactory.IdFactory;
import gr.uoi.cse.idfactory.IntegerIdFactory;
import gr.uoi.cse.parser.Parser;

public final class CountryParser implements Parser<List<Country>>
{	
	@Override
	public List<Country> parseDocument(String path)
	{
		final List<Country> countryList = new ArrayList<>();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			final IdFactory<Integer> idFactory = new IntegerIdFactory();
			final LineStringToCountryMapper lineStringToCountryMapper = new LineStringToCountryMapper();
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final int countryId = idFactory.createNextId();
				final Country country = lineStringToCountryMapper.map(line);
				country.setId(countryId);
				countryList.add(country);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return countryList;
	}
}