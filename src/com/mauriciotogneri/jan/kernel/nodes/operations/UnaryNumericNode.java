package com.mauriciotogneri.jan.kernel.nodes.operations;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

import java.math.BigDecimal;

public abstract class UnaryNumericNode extends PrimitiveNode
{
	protected UnaryNumericNode(Token token)
	{
		super(token, 1);
	}
	
	@Override
	public Value evaluate(Context context)
	{
		Value operand = get(0, context);
		
		if (operand.isNumber())
		{
			BigDecimal value = operand.getNumber();
			
			return evaluate(value);
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + token.lexeme + "' at: [" + token.line + ", " + token.column + "]");
	}
	
	protected abstract Value evaluate(BigDecimal operand);
}