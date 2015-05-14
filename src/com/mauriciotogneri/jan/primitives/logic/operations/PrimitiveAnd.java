package com.mauriciotogneri.jan.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.operands.BoolOperand;
import com.mauriciotogneri.jan.primitives.logic.base.PrimitiveLogicBinaryBoolean;

public class PrimitiveAnd extends PrimitiveLogicBinaryBoolean
{
	public static final String SYMBOL = "&";
	
	public PrimitiveAnd()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolOperand apply(boolean operand1, boolean operand2)
	{
		return new BoolOperand(operand1 && operand2);
	}
}