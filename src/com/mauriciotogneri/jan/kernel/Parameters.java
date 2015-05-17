package com.mauriciotogneri.jan.kernel;

import java.util.HashMap;
import java.util.Map;

public class Parameters
{
	private int index = 0;
	private final Map<String, Integer> parameters = new HashMap<>();
	
	public void add(String name)
	{
		this.parameters.put(name, this.index++);
	}
	
	public int getSize()
	{
		return this.parameters.size();
	}
	
	public boolean containsParameter(String name)
	{
		return this.parameters.containsKey(name);
	}
	
	public int getIndex(String name)
	{
		Integer result = this.parameters.get(name);
		
		return (result != null) ? result : -1;
	}
}