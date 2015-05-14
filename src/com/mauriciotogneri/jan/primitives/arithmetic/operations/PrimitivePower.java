package com.mauriciotogneri.jan.primitives.arithmetic.operations;

import com.mauriciotogneri.jan.kernel.values.FloatValue;
import com.mauriciotogneri.jan.kernel.values.IntValue;
import com.mauriciotogneri.jan.primitives.arithmetic.base.PrimitiveArithmeticBinary;

public class PrimitivePower extends PrimitiveArithmeticBinary
{
	public static final String SYMBOL = "^";
	
	public PrimitivePower()
	{
		super(SYMBOL);
	}
	
	@Override
	protected IntValue apply(long operand1, long operand2)
	{
		return new IntValue((long)Math.pow(operand1, operand2));
	}
	
	@Override
	protected FloatValue apply(double operand1, double operand2)
	{
		return new FloatValue(Math.pow(operand1, operand2));
	}
}