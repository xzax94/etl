package gr.uoi.cse.infantmortality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class InfantMortalityParser implements Parser<List<InfantMortality>>
{
	@Override
	public List<InfantMortality> parseDocument(String path)
	{
		final List<InfantMortality> infantMortalityList = new ArrayList<>();
		final LineStringToInfantMortalityMapper lineStringToInfantMortalityMapper = new LineStringToInfantMortalityMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final InfantMortality infantMortality = lineStringToInfantMortalityMapper.map(line);
				if (infantMortality == null)
					continue;
				
				infantMortalityList.add(infantMortality);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return infantMortalityList;
	}
}