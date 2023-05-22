package gr.uoi.cse.midyearpopulationbyagesex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class MidYearPopulationByAgeSexParser implements Parser<List<MidYearPopulationByAgeSex>>
{
	@Override
	public List<MidYearPopulationByAgeSex> parseDocument(String path) 
	{
		final List<MidYearPopulationByAgeSex> midYearPopulationByAgeSexList = new ArrayList<>();
		final LineStringToMidYearPopulationByAgeSexMapper lineStringToMidYearPopulationByAgeSexMapper = new LineStringToMidYearPopulationByAgeSexMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final List<MidYearPopulationByAgeSex> tempMidYearPopulationByAgeSexList = lineStringToMidYearPopulationByAgeSexMapper.map(line);
				tempMidYearPopulationByAgeSexList.forEach(midYearPopulationByAgeSexList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return midYearPopulationByAgeSexList;
	}
}