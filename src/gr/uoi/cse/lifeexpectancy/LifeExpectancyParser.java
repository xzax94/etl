package gr.uoi.cse.lifeexpectancy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class LifeExpectancyParser implements Parser<List<LifeExpectancy>>
{
	@Override
	public List<LifeExpectancy> parseDocument(String path)
	{
		final List<LifeExpectancy> lifeExpectancyList = new ArrayList<>();
		final LineStringToLifeExpectancyMapper lineStringToLifeExpectancyMapper = new LineStringToLifeExpectancyMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final LifeExpectancy lifeExpectancy = lineStringToLifeExpectancyMapper.map(line);
				if (lifeExpectancy == null)
					continue;
				
				lifeExpectancyList.add(lifeExpectancy);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return lifeExpectancyList;
	}
}