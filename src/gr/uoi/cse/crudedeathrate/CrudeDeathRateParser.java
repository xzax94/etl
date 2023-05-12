package gr.uoi.cse.crudedeathrate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class CrudeDeathRateParser implements Parser<List<CrudeDeathRate>>
{
	@Override
	public List<CrudeDeathRate> parseDocument(String path) 
	{
		final List<CrudeDeathRate> crudeDeathRateList = new ArrayList<>();
		final LineStringToCrudeDeathRateMapper lineStringToCrudeDeathRateMapper = new LineStringToCrudeDeathRateMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final CrudeDeathRate crudeDeathRate = lineStringToCrudeDeathRateMapper.map(line);
				if (crudeDeathRate == null)
					continue;
				
				crudeDeathRateList.add(crudeDeathRate);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return crudeDeathRateList;
	}
}