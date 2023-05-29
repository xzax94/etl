package gr.uoi.cse;

import gr.uoi.cse.etl.ETLFacade;

public final class Main
{
	public static void main (String ... args)
	{
		final ETLFacade etlFacade = new ETLFacade();
		etlFacade.performETL();
	}
}