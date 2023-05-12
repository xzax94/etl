package gr.uoi.cse.idfactory;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public final class IntegerIdFactory implements IdFactory<Integer>
{
	private final AtomicInteger nextId = new AtomicInteger(0);
	
	@Override
	public final Integer createNextId() 
	{
		return nextId.incrementAndGet();
	}
}