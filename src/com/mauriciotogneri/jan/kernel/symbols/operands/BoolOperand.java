package com.mauriciotogneri.jan.kernel.symbols.operands;

import com.mauriciotogneri.jan.kernel.symbols.Operand;

public class BoolOperand extends Operand
{
	public BoolOperand(boolean value)
	{
		super(Type.BOOLEAN, value);
	}
}