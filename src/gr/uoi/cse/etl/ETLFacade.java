package gr.uoi.cse.etl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import gr.uoi.cse.classcollector.ClassCollector;
import gr.uoi.cse.parser.Parser;
import gr.uoi.cse.writer.DiskWriter;

public final class ETLFacade
{
	private static final String PROJECT_BASE_PATH = "gr.uoi.cse";
	
	public void performETL()
	{
		final ClassCollector classCollector = new ClassCollector();
		final List<Class<?>> etlClassList = classCollector
				.collectClasses(PROJECT_BASE_PATH)
				.stream()
				.filter(c -> c.isAnnotationPresent(ETL.class))
				.toList();
		
		try
		{
			for (final Class<?> etlClass : etlClassList)
				performEtl(etlClass);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private final void performEtl(Class<?> etlClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		final ETL etlAnnotation = etlClass.getAnnotation(ETL.class);
		final String parseDirectory = etlAnnotation.parseDirectory();
		final String outputDirectory = etlAnnotation.outputDirectory();
		final Class<? extends Parser<?>> parserClass = etlAnnotation.parserClass();
		final Parser<?> parser = parserClass.getDeclaredConstructor().newInstance();
		final List<?> entityList = parser.parseDocument(parseDirectory);
		
		final DiskWriter diskWriter = new DiskWriter();
		diskWriter.writeToDisk(entityList, outputDirectory);
	}
}