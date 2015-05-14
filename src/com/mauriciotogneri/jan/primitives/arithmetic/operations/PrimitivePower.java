package com.mauriciotogneri.jan.primitives.arithmetic.operations;

import com.mauriciotogneri.jan.kernel.operands.FloatOperand;
import com.mauriciotogneri.jan.kernel.operands.IntOperand;
import com.mauriciotogneri.jan.primitives.arithmetic.base.PrimitiveArithmeticBinary;

public class PrimitivePower extends PrimitiveArithmeticBinary
{
	public static final String SYMBOL = "^";
	
	public PrimitivePower()
	{
		super(SYMBOL);
	}
	
	@Override
	protected IntOperand apply(long operand1, long operand2)
	{
		return new IntOperand((long)Math.pow(operand1, operand2));
	}
	
	@Override
	protected FloatOperand apply(double operand1, double operand2)
	{
		return new FloatOperand(Math.pow(operand1, operand2));
	}
}