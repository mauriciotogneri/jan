package com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations;

import com.mauriciotogneri.jan.kernel.symbols.operands.BoolOperand;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.base.PrimitiveLogicUnary;

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