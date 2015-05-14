package com.mauriciotogneri.jan.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.operands.BoolOperand;
import com.mauriciotogneri.jan.primitives.logic.base.PrimitiveLogicBinaryNumeric;

public class PrimitiveLessThan extends PrimitiveLogicBinaryNumeric
{
	public static final String SYMBOL = "<";
	
	public PrimitiveLessThan()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolOperand apply(double operand1, double operand2)
	{
		return new BoolOperand(operand1 < operand2);
	}
}