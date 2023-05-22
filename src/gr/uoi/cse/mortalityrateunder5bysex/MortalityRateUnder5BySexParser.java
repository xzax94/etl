package gr.uoi.cse.mortalityrateunder5bysex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class MortalityRateUnder5BySexParser implements Parser<List<MortalityRateUnder5BySex>>
{
	@Override
	public List<MortalityRateUnder5BySex> parseDocument(String path)
	{
		final List<MortalityRateUnder5BySex> mortalityRateUnder5BySexList = new ArrayList<>();
		final LineStringToMortalityRateUnder5BySexMapper lineStringToMortalityRateUnder5BySexMapper = new LineStringToMortalityRateUnder5BySexMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();

			while ((line = reader.readLine()) != null)
			{
				final List<MortalityRateUnder5BySex> tempMortalityRateUnder5BySexList = lineStringToMortalityRateUnder5BySexMapper.map(line);
				tempMortalityRateUnder5BySexList.forEach(mortalityRateUnder5BySexList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return mortalityRateUnder5BySexList;
	}
}