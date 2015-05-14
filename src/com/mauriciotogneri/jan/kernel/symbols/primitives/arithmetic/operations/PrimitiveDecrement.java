package com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations;

import com.mauriciotogneri.jan.kernel.symbols.operands.FloatOperand;
import com.mauriciotogneri.jan.kernel.symbols.operands.IntOperand;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.base.PrimitiveArithmeticUnary;

public class PrimitiveDecrement extends PrimitiveArithmeticUnary
{
	public static final String SYMBOL = "--";
	
	public PrimitiveDecrement()
	{
		super(SYMBOL);
	}
	
	@Override
	protected IntOperand apply(long operand)
	{
		return new IntOperand(operand - 1);
	}
	
	@Override
	protected FloatOperand apply(double operand)
	{
		return new FloatOperand(operand - 1);
	}
}