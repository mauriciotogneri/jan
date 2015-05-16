package com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.kernel.symbols.operands.BoolOperand;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.base.PrimitiveLogicBinaryNumeric;

public class PrimitiveNotEqual extends PrimitiveLogicBinaryNumeric
{
	public static final String SYMBOL = "!=";
	
	public PrimitiveNotEqual()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolOperand apply(BigDecimal operand1, BigDecimal operand2)
	{
		return new BoolOperand(operand1.compareTo(operand2) != 0);
	}
}