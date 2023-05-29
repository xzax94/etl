package gr.uoi.cse.fertilityrate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class FertilityRateParser implements Parser<FertilityRate>
{
	@Override
	public List<FertilityRate> parseDocument(String path)
	{
		final List<FertilityRate> fertilityRateList = new ArrayList<>();
		final LineStringToFertilityRateListMapper lineStringToFertilityRateListMapper = new LineStringToFertilityRateListMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final List<FertilityRate> tempFertilityRateList = lineStringToFertilityRateListMapper.map(line);
				tempFertilityRateList.forEach(fertilityRateList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return fertilityRateList;
	}
}