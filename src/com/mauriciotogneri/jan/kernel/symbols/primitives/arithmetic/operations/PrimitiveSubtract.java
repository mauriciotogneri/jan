package com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations;

import com.mauriciotogneri.jan.kernel.symbols.operands.FloatOperand;
import com.mauriciotogneri.jan.kernel.symbols.operands.IntOperand;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.base.PrimitiveArithmeticBinary;

public class PrimitiveSubtract extends PrimitiveArithmeticBinary
{
	public static final String SYMBOL = "-";
	
	public PrimitiveSubtract()
	{
		super(SYMBOL);
	}
	
	@Override
	protected IntOperand apply(long operand1, long operand2)
	{
		return new IntOperand(operand1 - operand2);
	}
	
	@Override
	protected FloatOperand apply(double operand1, double operand2)
	{
		return new FloatOperand(operand1 - operand2);
	}
}