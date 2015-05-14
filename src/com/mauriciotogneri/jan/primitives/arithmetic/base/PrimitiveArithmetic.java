package com.mauriciotogneri.jan.primitives.arithmetic.base;

import com.mauriciotogneri.jan.primitives.PrimitiveFunction;

public abstract class PrimitiveArithmetic implements PrimitiveFunction
{
	protected final String symbol;
	
	public PrimitiveArithmetic(String symbol)
	{
		this.symbol = symbol;
	}
}