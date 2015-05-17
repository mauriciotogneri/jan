package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ExpressionDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ProgramDefinition;

public class ExpressionEndState extends State
{
	private final FunctionDefinition function;
	private final ExpressionDefinition expression;
	
	public ExpressionEndState(ProgramDefinition program, FunctionDefinition function, ExpressionDefinition expression)
	{
		super(program);
		
		this.function = function;
		this.expression = expression;
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type.isSeparator())
		{
			return new ExpressionStartState(getProgram(), this.function, this.expression);
		}
		else if (token.type == Type.NEW_LINE)
		{
			this.function.addExpression(this.expression);
			
			return new FunctionDefinedState(getProgram(), this.function);
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}