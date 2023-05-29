package gr.uoi.cse.ratenaturalincrease;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gr.uoi.cse.parser.Parser;

public final class RateNaturalIncreaseParser implements Parser<RateNaturalIncrease>
{
	@Override
	public List<RateNaturalIncrease> parseDocument(String path) 
	{
		final List<RateNaturalIncrease> rateNaturalIncreaseList = new ArrayList<>();
		final LineStringToRateNaturalIncreaseMapper lineStringToRateNaturalIncreaseMapper = new LineStringToRateNaturalIncreaseMapper();
		
		try(final BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null)
			{
				final RateNaturalIncrease rateNaturalIncrease = lineStringToRateNaturalIncreaseMapper.map(line);
				if (rateNaturalIncrease == null)
					continue;
				
				rateNaturalIncreaseList.add(rateNaturalIncrease);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		
		return rateNaturalIncreaseList;
	}
}