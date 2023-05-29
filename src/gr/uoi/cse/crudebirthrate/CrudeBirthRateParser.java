package gr.uoi.cse.crudebirthrate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class CrudeBirthRateParser implements Parser<CrudeBirthRate>
{	
	@Override
	public List<CrudeBirthRate> parseDocument(String path)
	{
		final List<CrudeBirthRate> crudeBirthRateList = new ArrayList<>();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			final LineStringToCrudeBirthRateMapper lineStringToCrudeBirthRateMapper = new LineStringToCrudeBirthRateMapper();
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final CrudeBirthRate crudeBirthRate = lineStringToCrudeBirthRateMapper.map(line);
				if (crudeBirthRate == null)
					continue;
				
				crudeBirthRateList.add(crudeBirthRate);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return crudeBirthRateList;
	}
}