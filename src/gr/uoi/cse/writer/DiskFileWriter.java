package gr.uoi.cse.writer;

import java.util.List;

@FunctionalInterface
public interface DiskFileWriter<T>
{
	void writeToDisk(List<T> entityList, String path);
}