package com.mauriciotogneri.jan.kernel.operands;

import com.mauriciotogneri.jan.kernel.Operand;

public class FloatOperand extends Operand
{
	public FloatOperand(double value)
	{
		super(Type.FLOAT, value);
	}
}