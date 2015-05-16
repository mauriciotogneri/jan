package com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.kernel.symbols.operands.NumberOperand;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.base.PrimitiveArithmeticBinary;

public class PrimitiveModule extends PrimitiveArithmeticBinary
{
	public static final String SYMBOL = "%";
	
	public PrimitiveModule()
	{
		super(SYMBOL);
	}
	
	@Override
	protected NumberOperand apply(BigDecimal operand1, BigDecimal operand2)
	{
		return new NumberOperand(operand1.remainder(operand2));
	}
}