package com.mauriciotogneri.jan.primitives.arithmetic.base;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.values.FloatValue;
import com.mauriciotogneri.jan.kernel.values.IntValue;

public abstract class PrimitiveArithmeticUnary extends PrimitiveArithmetic
{
	public PrimitiveArithmeticUnary(String symbol)
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
		
		if (!operand.isNumber())
		{
			throw new RuntimeException("Invalid operands to perfom " + this.symbol);
		}
		
		if (operand.isInt())
		{
			stack.push(apply(operand.getInt()));
		}
		else
		{
			stack.push(apply(operand.getFloat()));
		}
	}
	
	protected abstract IntValue apply(long operand);
	
	protected abstract FloatValue apply(double operand);
}