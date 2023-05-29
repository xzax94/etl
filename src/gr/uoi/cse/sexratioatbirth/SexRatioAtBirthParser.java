package gr.uoi.cse.sexratioatbirth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class SexRatioAtBirthParser implements Parser<SexRatioAtBirth>
{
	@Override
	public List<SexRatioAtBirth> parseDocument(String path) 
	{
		final List<SexRatioAtBirth> sexRatioAtBirthList = new ArrayList<>();
		final LineStringToSexRatioAtBirthMapper lineStringToSexRatioAtBirthMapper = new LineStringToSexRatioAtBirthMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final SexRatioAtBirth sexRatioAtBirth = lineStringToSexRatioAtBirthMapper.map(line);
				if (sexRatioAtBirth == null)
					continue;
				
				sexRatioAtBirthList.add(sexRatioAtBirth);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return sexRatioAtBirthList;
	}
}