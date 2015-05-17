package com.mauriciotogneri.jan.compiler.semantic.nodes.operations;

import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

public abstract class BinaryBooleanNode extends PrimitiveNode
{
	public BinaryBooleanNode(Token token)
	{
		super(token, 2);
	}
	
	@Override
	public Value evaluate(ProgramDefinition program, Context context)
	{
		Value operand1 = get(0, program, context);
		Value operand2 = get(1, program, context);
		
		if (operand1.isBoolean() && operand2.isBoolean())
		{
			Boolean value1 = operand1.getBoolean();
			Boolean value2 = operand2.getBoolean();
			
			return evaluate(value1, value2);
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + this.token.lexeme + "' at: [" + this.token.line + ", " + this.token.column + "]");
	}
	
	protected abstract Value evaluate(Boolean operand1, Boolean operand2);
}