package com.mauriciotogneri.jan.primitives.logic.base;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.values.BoolValue;

public abstract class PrimitiveLogicUnary extends PrimitiveLogic
{
	public PrimitiveLogicUnary(String symbol)
	{
		super(symbol);
	}
	
	@Override
	public void apply(Stack<Value> stack)
	{
		if (stack.size() < 1)
		{
			throw new RuntimeException("Insufficient operands in stack to perform " + this.symbol);
		}
		
		Value operand = stack.pop();
		
		if (!operand.isBoolean())
		{
			throw new RuntimeException("Invalid operands to perfom " + this.symbol);
		}
		
		stack.push(apply(operand.getBoolean()));
	}
	
	protected abstract BoolValue apply(boolean operand);
}