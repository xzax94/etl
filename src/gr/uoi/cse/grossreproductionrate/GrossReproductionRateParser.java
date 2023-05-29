package gr.uoi.cse.grossreproductionrate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class GrossReproductionRateParser implements Parser<GrossReproductionRate>
{
	@Override
	public List<GrossReproductionRate> parseDocument(String path) 
	{
		final List<GrossReproductionRate> grossReproductionRateList = new ArrayList<>();
		final LineStringToGrossReproductionRateMapper lineStringToGrossReproductionRateMapper = new LineStringToGrossReproductionRateMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final GrossReproductionRate grossReproductionRate = lineStringToGrossReproductionRateMapper.map(line);
				if (grossReproductionRate == null)
					continue;
				
				grossReproductionRateList.add(grossReproductionRate);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return grossReproductionRateList;
	}
}