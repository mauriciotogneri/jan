package com.mauriciotogneri.jan.kernel.symbols.operands;

import com.mauriciotogneri.jan.kernel.symbols.Operand;

public class IntOperand extends Operand
{
	public IntOperand(long value)
	{
		super(Type.INT, value);
	}
}