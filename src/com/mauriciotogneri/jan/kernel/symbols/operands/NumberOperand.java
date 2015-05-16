package com.mauriciotogneri.jan.kernel.symbols.operands;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.kernel.symbols.Operand;

public class NumberOperand extends Operand
{
	public NumberOperand(long value)
	{
		super(Type.NUMBER, BigDecimal.valueOf(value));
	}
	
	public NumberOperand(BigDecimal value)
	{
		super(Type.NUMBER, value);
	}
}