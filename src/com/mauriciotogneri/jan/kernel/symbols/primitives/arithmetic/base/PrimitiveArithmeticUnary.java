package com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.base;

import java.math.BigDecimal;
import java.util.Stack;
import com.mauriciotogneri.jan.kernel.symbols.Operand;
import com.mauriciotogneri.jan.kernel.symbols.operands.NumberOperand;

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
		
		stack.push(apply(operand.getNumber()));
	}
	
	protected abstract NumberOperand apply(BigDecimal operand);
}