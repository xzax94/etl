package gr.uoi.cse.etl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import gr.uoi.cse.parser.Parser;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface ETL
{
	Class<? extends Parser<?>> parserClass();
	
	String parseDirectory();
	
	String outputDirectory();
}