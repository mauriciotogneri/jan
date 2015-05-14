package com.mauriciotogneri.jan.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.values.BoolValue;
import com.mauriciotogneri.jan.primitives.logic.base.PrimitiveLogicBinaryNumeric;

public class PrimitiveGreaterThanOrEqual extends PrimitiveLogicBinaryNumeric
{
	public static final String SYMBOL = ">=";
	
	public PrimitiveGreaterThanOrEqual()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolValue apply(double operand1, double operand2)
	{
		return new BoolValue(operand1 >= operand2);
	}
}