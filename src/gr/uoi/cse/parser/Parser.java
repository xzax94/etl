package gr.uoi.cse.parser;

import java.util.List;

@FunctionalInterface
public interface Parser<T>
{
	List<T> parseDocument(String path);
}