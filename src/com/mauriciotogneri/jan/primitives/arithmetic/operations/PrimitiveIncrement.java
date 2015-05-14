package com.mauriciotogneri.jan.primitives.arithmetic.operations;

import com.mauriciotogneri.jan.kernel.values.FloatValue;
import com.mauriciotogneri.jan.kernel.values.IntValue;
import com.mauriciotogneri.jan.primitives.arithmetic.base.PrimitiveArithmeticUnary;

public class PrimitiveIncrement extends PrimitiveArithmeticUnary
{
	public static final String SYMBOL = "++";
	
	public PrimitiveIncrement()
	{
		super(SYMBOL);
	}
	
	@Override
	protected IntValue apply(long operand)
	{
		return new IntValue(operand + 1);
	}
	
	@Override
	protected FloatValue apply(double operand)
	{
		return new FloatValue(operand + 1);
	}
}