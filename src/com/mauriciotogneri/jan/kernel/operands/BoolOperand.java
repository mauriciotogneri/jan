package com.mauriciotogneri.jan.kernel.operands;

import com.mauriciotogneri.jan.kernel.Operand;

public class BoolOperand extends Operand
{
	public BoolOperand(boolean value)
	{
		super(Type.BOOLEAN, value);
	}
}