package com.mauriciotogneri.jan.kernel.symbols.primitives.logic.base;

import com.mauriciotogneri.jan.kernel.symbols.primitives.PrimitiveFunction;

public abstract class PrimitiveLogic implements PrimitiveFunction
{
	protected final String symbol;
	
	public PrimitiveLogic(String symbol)
	{
		this.symbol = symbol;
	}
}