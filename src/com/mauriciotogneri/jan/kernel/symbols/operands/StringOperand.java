package com.mauriciotogneri.jan.kernel.symbols.operands;

import com.mauriciotogneri.jan.kernel.symbols.Operand;

public class StringOperand extends Operand
{
	public StringOperand(String value)
	{
		super(Type.STRING, value);
	}
}