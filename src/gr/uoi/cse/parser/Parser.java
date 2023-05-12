package gr.uoi.cse.parser;

@FunctionalInterface
public interface Parser<T>
{
	T parseDocument(String path);
}