package gr.uoi.cse.mortalityrate1to4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class MortalityRate1To4Parser implements Parser<MortalityRate1To4>
{
	@Override
	public List<MortalityRate1To4> parseDocument(String path)
	{
		final List<MortalityRate1To4> mortalityRate1To4List = new ArrayList<>();
		final LineStringToMortalityRate1To4Mapper lineStringToMortalityRate1To4Mapper = new LineStringToMortalityRate1To4Mapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final MortalityRate1To4 mortalityRate1To4 = lineStringToMortalityRate1To4Mapper.map(line);
				if (mortalityRate1To4 == null)
					continue;
				
				mortalityRate1To4List.add(mortalityRate1To4);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return mortalityRate1To4List;
	}
}