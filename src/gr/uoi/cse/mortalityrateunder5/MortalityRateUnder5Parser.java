package gr.uoi.cse.mortalityrateunder5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class MortalityRateUnder5Parser implements Parser<MortalityRateUnder5>
{
	@Override
	public List<MortalityRateUnder5> parseDocument(String path)
	{
		final List<MortalityRateUnder5> mortalityRateUnder5List = new ArrayList<>();
		final LineStringToMortalityRateUnder5Mapper lineStringToMortalityRateUnder5Mapper = new LineStringToMortalityRateUnder5Mapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final MortalityRateUnder5 mortalityRateUnder5 = lineStringToMortalityRateUnder5Mapper.map(line);
				if (mortalityRateUnder5 == null)
					continue;
				
				mortalityRateUnder5List.add(mortalityRateUnder5);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return mortalityRateUnder5List;
	}
}