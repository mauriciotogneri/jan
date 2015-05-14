package com.mauriciotogneri.prefix;

import com.mauriciotogneri.prefix.Value.Type;

public class Parameter
{
	public final String name;
	public final Type type;
	
	public Parameter(String name, Type type)
	{
		this.name = name;
		this.type = type;
	}
}