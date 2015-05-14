package com.mauriciotogneri.jan.primitives.arithmetic.operations;

import com.mauriciotogneri.jan.kernel.values.FloatValue;
import com.mauriciotogneri.jan.kernel.values.IntValue;
import com.mauriciotogneri.jan.primitives.arithmetic.base.PrimitiveArithmeticBinary;

public class PrimitiveSubtract extends PrimitiveArithmeticBinary
{
	public static final String SYMBOL = "-";
	
	public PrimitiveSubtract()
	{
		super(SYMBOL);
	}
	
	@Override
	protected IntValue apply(long operand1, long operand2)
	{
		return new IntValue(operand1 - operand2);
	}
	
	@Override
	protected FloatValue apply(double operand1, double operand2)
	{
		return new FloatValue(operand1 - operand2);
	}
}