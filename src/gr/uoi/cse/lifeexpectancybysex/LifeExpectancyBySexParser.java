package gr.uoi.cse.lifeexpectancybysex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class LifeExpectancyBySexParser implements Parser<List<LifeExpectancyBySex>>
{
	@Override
	public List<LifeExpectancyBySex> parseDocument(String path)
	{
		final List<LifeExpectancyBySex> lifeExpectancyList = new ArrayList<>();
		final LineStringToLifeExpectancyBySexMapper lineStringToLifeExpectancyBySexMapper = new LineStringToLifeExpectancyBySexMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();

			while ((line = reader.readLine()) != null)
			{
				final List<LifeExpectancyBySex> tempLifeExpectancyBySexList = lineStringToLifeExpectancyBySexMapper.map(line);
				tempLifeExpectancyBySexList.forEach(lifeExpectancyList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return lifeExpectancyList;
	}
}