package com.mauriciotogneri.jan.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.operands.BoolOperand;
import com.mauriciotogneri.jan.primitives.logic.base.PrimitiveLogicUnary;

public class PrimitiveNegation extends PrimitiveLogicUnary
{
	public static final String SYMBOL = "!";
	
	public PrimitiveNegation()
	{
		super(SYMBOL);
	}
	
	@Override
	protected BoolOperand apply(boolean operand1)
	{
		return new BoolOperand(!operand1);
	}
}