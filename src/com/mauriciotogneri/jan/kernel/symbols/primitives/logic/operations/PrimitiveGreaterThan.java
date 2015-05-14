package com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.symbols.operands.BoolOperand;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.base.PrimitiveLogicBinaryNumeric;

public class PrimitiveGreaterThan extends PrimitiveLogicBinaryNumeric
{
	public static final String SYMBOL = ">";
	
	public PrimitiveGreaterThan()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolOperand apply(double operand1, double operand2)
	{
		return new BoolOperand(operand1 > operand2);
	}
}