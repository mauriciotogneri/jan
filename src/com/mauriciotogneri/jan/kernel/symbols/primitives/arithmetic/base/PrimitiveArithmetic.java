package com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.base;

import com.mauriciotogneri.jan.kernel.symbols.primitives.PrimitiveFunction;

public abstract class PrimitiveArithmetic implements PrimitiveFunction
{
	protected final String symbol;
	
	public PrimitiveArithmetic(String symbol)
	{
		this.symbol = symbol;
	}
}