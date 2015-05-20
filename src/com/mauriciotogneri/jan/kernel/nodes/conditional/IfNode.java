package com.mauriciotogneri.jan.kernel.nodes.conditional;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

public class IfNode extends PrimitiveNode
{
	public IfNode(Token token)
	{
		super(token, 2);
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
				return null;
			}
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + this.token.lexeme + "' at: [" + this.token.line + ", " + this.token.column + "]");
	}
}