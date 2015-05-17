package com.mauriciotogneri.jan.compiler.semantic.nodes.operations;

import java.math.BigDecimal;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

public abstract class BinaryNumericNode extends PrimitiveNode
{
	public BinaryNumericNode(Token token)
	{
		super(token, 2);
	}
	
	@Override
	public Value evaluate(ProgramDefinition program, Context context)
	{
		Value operand1 = get(0, program, context);
		Value operand2 = get(1, program, context);
		
		if (operand1.isNumber() && operand2.isNumber())
		{
			BigDecimal value1 = operand1.getNumber();
			BigDecimal value2 = operand2.getNumber();
			
			return evaluate(value1, value2);
		}
		
		// TODO: explain more
		throw new RuntimeException("Cannot perform operation '" + this.token.lexeme + "' at: [" + this.token.line + ", " + this.token.column + "]");
	}
	
	protected abstract Value evaluate(BigDecimal operand1, BigDecimal operand2);
}