package com.mauriciotogneri.jan.kernel.symbols.primitives.logic.base;

import java.math.BigDecimal;
import java.util.Stack;
import com.mauriciotogneri.jan.kernel.symbols.Operand;
import com.mauriciotogneri.jan.kernel.symbols.operands.BoolOperand;

public abstract class PrimitiveLogicBinaryNumeric extends PrimitiveLogic
{
	public PrimitiveLogicBinaryNumeric(String symbol)
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
		
		if (!operand1.isNumber() || !operand2.isNumber())
		{
			throw new RuntimeException("Invalid operands to perfom " + this.symbol);
		}
		
		stack.push(apply(operand1.getNumber(), operand2.getNumber()));
	}
	
	protected abstract BoolOperand apply(BigDecimal operand1, BigDecimal operand2);
}