package gr.uoi.cse.fertilityratetotal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class FertilityRateTotalParser implements Parser<FertilityRateTotal>
{
	@Override
	public List<FertilityRateTotal> parseDocument(String path) 
	{
		final List<FertilityRateTotal> fertilityRateTotalList = new ArrayList<>();
		final LineStringToFertilityRateTotalMapper lineStringToFertilityRateTotalMapper = new LineStringToFertilityRateTotalMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final FertilityRateTotal fertilityRateTotal = lineStringToFertilityRateTotalMapper.map(line);
				if (fertilityRateTotal == null)
					continue;
				
				fertilityRateTotalList.add(fertilityRateTotal);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return fertilityRateTotalList;
	}
}