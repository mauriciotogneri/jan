package com.mauriciotogneri.jan.kernel.operands;

import com.mauriciotogneri.jan.kernel.Operand;

public class StringOperand extends Operand
{
	public StringOperand(String value)
	{
		super(Type.STRING, value);
	}
}