package gr.uoi.cse;


public final class Test
{
	
	public static void main (String ... args)
	{
		final String test = "a, , ,,a";
		System.out.println(test.split(",").length);
	}
}