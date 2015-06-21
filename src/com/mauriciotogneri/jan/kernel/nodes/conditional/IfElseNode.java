package com.mauriciotogneri.jan.kernel.nodes.conditional;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

public class IfElseNode extends PrimitiveNode
{
	public IfElseNode(Token token)
	{
		super(token, 3);
	}
	
	@Override
	public Value evaluate(Context context)
	{
		Value operand1 = get(0, context);
		
		if (operand1.isBoolean())
		{
			if (operand1.getBoolean())
			{
				return get(1, context);
			}
			else
			{
				return get(2, context);
			}
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + token.lexeme + "' at: [" + token.line + ", " + token.column + "]");
	}
}