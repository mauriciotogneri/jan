package com.mauriciotogneri.jan.primitives.conditional;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.Operand;
import com.mauriciotogneri.jan.primitives.PrimitiveFunction;

public class PrimitiveIf implements PrimitiveFunction
{
	public static final String SYMBOL = "?";
	
	@Override
	public void apply(Stack<Operand> stack)
	{
		if (stack.size() < 2)
		{
			throw new RuntimeException("Insufficient operands in stack to perform ?");
		}
		
		Operand operand1 = stack.pop();
		
		if (!operand1.isBoolean())
		{
			throw new RuntimeException("Invalid operands to perfom ?");
		}
		
		if (!operand1.getBoolean())
		{
			stack.pop();
		}
	}
}