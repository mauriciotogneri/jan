package com.mauriciotogneri.jan.primitives.logic.base;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.values.BoolValue;

public abstract class PrimitiveLogicBinaryNumeric extends PrimitiveLogic
{
	public PrimitiveLogicBinaryNumeric(String symbol)
	{
		super(symbol);
	}
	
	@Override
	public void apply(Stack<Value> stack)
	{
		if (stack.size() < 2)
		{
			throw new RuntimeException("Insufficient operands in stack to perform " + this.symbol);
		}
		
		Value operand1 = stack.pop();
		Value operand2 = stack.pop();
		
		if (!operand1.isNumber() || !operand2.isNumber())
		{
			throw new RuntimeException("Invalid operands to perfom " + this.symbol);
		}
		
		if (operand1.isInt() || operand2.isInt())
		{
			stack.push(apply(operand1.getInt(), operand2.getInt()));
		}
		else
		{
			if (operand1.isInt() && operand2.isFloat())
			{
				stack.push(apply(operand1.getInt(), operand2.getFloat()));
			}
			else if (operand1.isFloat() && operand2.isInt())
			{
				stack.push(apply(operand1.getFloat(), operand2.getInt()));
			}
			else
			{
				stack.push(apply(operand1.getFloat(), operand2.getFloat()));
			}
		}
	}
	
	protected abstract BoolValue apply(double operand1, double operand2);
}