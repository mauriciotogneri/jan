package com.mauriciotogneri.jan.compiler.semantic.nodes.operations;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

public abstract class UnaryNumericNode extends PrimitiveNode
{
	public UnaryNumericNode(Token token)
	{
		super(token, 1);
	}
	
	@Override
	public Value evaluate(ProgramDefinition program, Context context)
	{
		Value operand = get(0, program, context);
		
		if (operand.isNumber())
		{
			BigDecimal value = operand.getNumber();
			
			return evaluate(value);
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + this.token.lexeme + "' at: [" + this.token.line + ", " + this.token.column + "]");
	}
	
	protected abstract Value evaluate(BigDecimal operand);
}