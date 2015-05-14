package com.mauriciotogneri.jan.kernel.operands;

import com.mauriciotogneri.jan.kernel.Operand;

public class IntOperand extends Operand
{
	public IntOperand(long value)
	{
		super(Type.INT, value);
	}
}