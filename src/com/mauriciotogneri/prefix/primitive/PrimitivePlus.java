package com.mauriciotogneri.prefix.primitive;

import java.util.Stack;
import com.mauriciotogneri.prefix.FloatValue;
import com.mauriciotogneri.prefix.IntValue;
import com.mauriciotogneri.prefix.Value;

public class PrimitivePlus implements PrimitiveFunction
{
	@Override
	public void apply(Stack<Value> stack)
	{
		Value result = applyOperationPlus(stack);
		stack.push(result);
	}
	
	private Value applyOperationPlus(Stack<Value> stack)
	{
		if (stack.size() < 2)
		{
			throw new RuntimeException("Insufficient operands in stack to perform +");
		}
		
		Value operand1 = stack.pop();
		Value operand2 = stack.pop();
		
		if (!operand1.isNumber() || !operand2.isNumber())
		{
			throw new RuntimeException("Invalid operands to perfom +");
		}
		
		if (operand1.isInt() || operand2.isInt())
		{
			return new IntValue(operand1.getInt() + operand2.getInt());
		}
		else
		{
			if (operand1.isInt() && operand2.isFloat())
			{
				return new FloatValue(operand1.getInt() + operand2.getFloat());
			}
			else if (operand1.isFloat() && operand2.isInt())
			{
				return new FloatValue(operand1.getFloat() + operand2.getInt());
			}
			else
			{
				return new FloatValue(operand1.getFloat() + operand2.getFloat());
			}
		}
	}
}