package com.mauriciotogneri.jan.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.values.BoolValue;
import com.mauriciotogneri.jan.primitives.logic.base.PrimitiveLogicUnary;

public class PrimitiveNegation extends PrimitiveLogicUnary
{
	public static final String SYMBOL = "!";
	
	public PrimitiveNegation()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolValue apply(boolean operand1)
	{
		return new BoolValue(!operand1);
	}
}