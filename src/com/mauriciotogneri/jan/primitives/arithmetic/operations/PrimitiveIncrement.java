package com.mauriciotogneri.jan.primitives.arithmetic.operations;

import com.mauriciotogneri.jan.kernel.operands.FloatOperand;
import com.mauriciotogneri.jan.kernel.operands.IntOperand;
import com.mauriciotogneri.jan.primitives.arithmetic.base.PrimitiveArithmeticUnary;

public class PrimitiveIncrement extends PrimitiveArithmeticUnary
{
	public static final String SYMBOL = "++";
	
	public PrimitiveIncrement()
	{
		super(SYMBOL);
	}
	
	@Override
	protected IntOperand apply(long operand)
	{
		return new IntOperand(operand + 1);
	}
	
	@Override
	protected FloatOperand apply(double operand)
	{
		return new FloatOperand(operand + 1);
	}
}