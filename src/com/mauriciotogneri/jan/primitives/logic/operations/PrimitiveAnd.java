package com.mauriciotogneri.jan.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.values.BoolValue;
import com.mauriciotogneri.jan.primitives.logic.base.PrimitiveLogicBinaryBoolean;

public class PrimitiveAnd extends PrimitiveLogicBinaryBoolean
{
	public static final String SYMBOL = "&";
	
	public PrimitiveAnd()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolValue apply(boolean operand1, boolean operand2)
	{
		return new BoolValue(operand1 && operand2);
	}
}