package com.mauriciotogneri.jan.kernel.symbols;

import com.mauriciotogneri.jan.kernel.Value;

public class Context
{
	private final Value[] values;
	
	public Context(Value... values)
	{
		this.values = values;
	}
	
	public Context()
	{
		this(new Value[0]);
	}
	
	public Value get(int index)
	{
		return this.values[index];
	}
}