package com.mauriciotogneri.jan.kernel.nodes.operations;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Program;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

public abstract class UnaryBooleanNode extends PrimitiveNode
{
	public UnaryBooleanNode(Token token)
	{
		super(token, 1);
	}
	
	@Override
	public Value evaluate(Program program, Context context)
	{
		Value operand = get(0, program, context);
		
		if (operand.isBoolean())
		{
			Boolean value = operand.getBoolean();
			
			return evaluate(value);
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + this.token.lexeme + "' at: [" + this.token.line + ", " + this.token.column + "]");
	}
	
	protected abstract Value evaluate(Boolean operand);
}