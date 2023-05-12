package gr.uoi.cse.growthrate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class GrowthRateParser implements Parser<List<GrowthRate>>
{
	@Override
	public List<GrowthRate> parseDocument(String path) 
	{
		final List<GrowthRate> growthRateList = new ArrayList<>();
		final LineStringToGrowthRateMapper lineStringToGrowthRateMapper = new LineStringToGrowthRateMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final GrowthRate growthRate = lineStringToGrowthRateMapper.map(line);
				if (growthRate == null)
					continue;
				
				growthRateList.add(growthRate);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return growthRateList;
	}
}