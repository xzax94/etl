package gr.uoi.cse.midyearpopulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class MidyearPopulationParser implements Parser<MidyearPopulation>
{
	@Override
	public List<MidyearPopulation> parseDocument(String path)
	{
		final List<MidyearPopulation> midyearPopulationList = new ArrayList<>();
		final LineStringToMidyearPopulationMapper lineStringToMidyearPopulationMapper = new LineStringToMidyearPopulationMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final MidyearPopulation midyearPopulation = lineStringToMidyearPopulationMapper.map(line);
				if (midyearPopulation == null)
					continue;
				
				midyearPopulationList.add(midyearPopulation);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return midyearPopulationList;
	}
}