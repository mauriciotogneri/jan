package com.mauriciotogneri.jan.primitives.logic.base;

import com.mauriciotogneri.jan.primitives.PrimitiveFunction;

public abstract class PrimitiveLogic implements PrimitiveFunction
{
	protected final String symbol;
	
	public PrimitiveLogic(String symbol)
	{
		this.symbol = symbol;
	}
}