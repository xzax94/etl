package gr.uoi.cse.mapper;

@FunctionalInterface
public interface Mapper <K, V>
{
	V map(K key);
	
	default Integer parseInteger(String string)
	{
		try
		{
			return Integer.parseInt(string);
		}
		catch (final Exception e)
		{
			return null;
		}
	}
	
	default boolean parseBoolean(String string)
	{
		try
		{
			return Boolean.parseBoolean(string);
		}
		catch (final Exception e)
		{
			return false;
		}
	}
	
	default Float parseFloat(String string)
	{
		try
		{
			return Float.parseFloat(string);
		}
		catch (final Exception e)
		{
			return null;
		}
	}
}