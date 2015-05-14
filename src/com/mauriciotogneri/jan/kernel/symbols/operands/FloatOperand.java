package com.mauriciotogneri.jan.kernel.symbols.operands;

import com.mauriciotogneri.jan.kernel.symbols.Operand;

public class FloatOperand extends Operand
{
	public FloatOperand(double value)
	{
		super(Type.FLOAT, value);
	}
}