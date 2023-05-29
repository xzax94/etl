package gr.uoi.cse.mortalityrate1to4bysex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class MortalityRate1To4BySexParser implements Parser<MortalityRate1To4BySex>
{
	@Override
	public List<MortalityRate1To4BySex> parseDocument(String path)
	{
		final List<MortalityRate1To4BySex> mortalityRate1To4BySexList = new ArrayList<>();
		final LineStringToMortalityRate1To4BySexMapper lineStringToMortalityRate1To4BySexMapper = new LineStringToMortalityRate1To4BySexMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();

			while ((line = reader.readLine()) != null)
			{
				final List<MortalityRate1To4BySex> tempMortalityRate1To4BySexList = lineStringToMortalityRate1To4BySexMapper.map(line);
				tempMortalityRate1To4BySexList.forEach(mortalityRate1To4BySexList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return mortalityRate1To4BySexList;
	}
}