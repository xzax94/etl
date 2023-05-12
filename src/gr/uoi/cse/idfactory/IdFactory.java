package gr.uoi.cse.idfactory;

@FunctionalInterface
public interface IdFactory<T>
{
	T createNextId();
}