package com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.base;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.symbols.Operand;
import com.mauriciotogneri.jan.kernel.symbols.operands.FloatOperand;
import com.mauriciotogneri.jan.kernel.symbols.operands.IntOperand;

public abstract class PrimitiveArithmeticUnary extends PrimitiveArithmetic
{
	public PrimitiveArithmeticUnary(String symbol)
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
	
	protected abstract IntOperand apply(long operand);
	
	protected abstract FloatOperand apply(double operand);
}