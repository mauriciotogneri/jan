package com.mauriciotogneri.prefix;

import com.mauriciotogneri.prefix.Value.Type;

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