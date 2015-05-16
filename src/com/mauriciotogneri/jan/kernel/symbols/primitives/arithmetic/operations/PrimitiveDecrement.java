package com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.kernel.symbols.operands.NumberOperand;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.base.PrimitiveArithmeticUnary;

public class PrimitiveDecrement extends PrimitiveArithmeticUnary
{
	public static final String SYMBOL = "--";
	
	public PrimitiveDecrement()
	{
		super(SYMBOL);
	}
	
	@Override
	protected NumberOperand apply(BigDecimal operand)
	{
		return new NumberOperand(operand.subtract(BigDecimal.ONE));
	}
}