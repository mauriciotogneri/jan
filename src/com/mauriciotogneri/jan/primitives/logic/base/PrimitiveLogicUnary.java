package com.mauriciotogneri.jan.primitives.logic.base;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.Operand;
import com.mauriciotogneri.jan.kernel.operands.BoolOperand;

public abstract class PrimitiveLogicUnary extends PrimitiveLogic
{
	public PrimitiveLogicUnary(String symbol)
	{
		super(symbol);
	}
	
	@Override
	public void apply(Stack<Operand> stack)
	{
		if (stack.size() < 1)
		{
			throw new RuntimeException("Insufficient operands in stack to perform " + this.symbol);
		}
		
		Operand operand = stack.pop();
		
		if (!operand.isBoolean())
		{
			throw new RuntimeException("Invalid operands to perfom " + this.symbol);
		}
		
		stack.push(apply(operand.getBoolean()));
	}
	
	protected abstract BoolOperand apply(boolean operand);
}