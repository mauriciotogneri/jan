package com.mauriciotogneri.jan.kernel.symbols;


public class Parameter implements Symbol
{
	public final String name;
	public final int index;
	
	public Parameter(String name, int index)
	{
		this.name = name;
		this.index = index;
	}
}