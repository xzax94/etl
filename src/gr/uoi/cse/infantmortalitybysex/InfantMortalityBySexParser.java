package gr.uoi.cse.infantmortalitybysex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class InfantMortalityBySexParser implements Parser<InfantMortalityBySex>
{
	@Override
	public List<InfantMortalityBySex> parseDocument(String path)
	{
		final List<InfantMortalityBySex> infantMortalityList = new ArrayList<>();
		final LineStringToInfantMortalityBySexMapper lineStringToInfantMortalityBySexMapper = new LineStringToInfantMortalityBySexMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();

			while ((line = reader.readLine()) != null)
			{
				final List<InfantMortalityBySex> tempInfantMortalityBySexList = lineStringToInfantMortalityBySexMapper.map(line);
				tempInfantMortalityBySexList.forEach(infantMortalityList::add);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return infantMortalityList;
	}
}