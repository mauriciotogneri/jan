package com.mauriciotogneri.jan.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.operands.BoolOperand;
import com.mauriciotogneri.jan.primitives.logic.base.PrimitiveLogicBinaryNumeric;

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