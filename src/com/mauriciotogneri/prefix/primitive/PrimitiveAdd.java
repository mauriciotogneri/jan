package com.mauriciotogneri.prefix.primitive;

import java.util.Stack;
import com.mauriciotogneri.prefix.kernel.Value;
import com.mauriciotogneri.prefix.kernel.values.FloatValue;
import com.mauriciotogneri.prefix.kernel.values.IntValue;

public class PrimitiveAdd implements PrimitiveFunction
{
	public static final String SYMBOL = "+";
	
	@Override
	public void apply(Stack<Value> stack)
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
			stack.push(new IntValue(operand1.getInt() + operand2.getInt()));
		}
		else
		{
			if (operand1.isInt() && operand2.isFloat())
			{
				stack.push(new FloatValue(operand1.getInt() + operand2.getFloat()));
			}
			else if (operand1.isFloat() && operand2.isInt())
			{
				stack.push(new FloatValue(operand1.getFloat() + operand2.getInt()));
			}
			else
			{
				stack.push(new FloatValue(operand1.getFloat() + operand2.getFloat()));
			}
		}
	}
}