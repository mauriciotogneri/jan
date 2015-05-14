package com.mauriciotogneri.jan.kernel;

import com.mauriciotogneri.jan.kernel.Value.Type;

public class Parameter
{
	public final String name;
	public final int index;
	public final Type type;
	
	public Parameter(String name, int index, Type type)
	{
		this.name = name;
		this.index = index;
		this.type = type;
	}
}