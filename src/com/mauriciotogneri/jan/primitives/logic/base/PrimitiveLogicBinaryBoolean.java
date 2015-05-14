package com.mauriciotogneri.jan.primitives.logic.base;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.Operand;
import com.mauriciotogneri.jan.kernel.operands.BoolOperand;

public abstract class PrimitiveLogicBinaryBoolean extends PrimitiveLogic
{
	public PrimitiveLogicBinaryBoolean(String symbol)
	{
		super(symbol);
	}
	
	@Override
	public void apply(Stack<Operand> stack)
	{
		if (stack.size() < 2)
		{
			throw new RuntimeException("Insufficient operands in stack to perform " + this.symbol);
		}
		
		Operand operand1 = stack.pop();
		Operand operand2 = stack.pop();
		
		if (!operand1.isBoolean() || !operand2.isBoolean())
		{
			throw new RuntimeException("Invalid operands to perfom " + this.symbol);
		}
		
		stack.push(apply(operand1.getBoolean(), operand2.getBoolean()));
	}
	
	protected abstract BoolOperand apply(boolean operand1, boolean operand2);
}