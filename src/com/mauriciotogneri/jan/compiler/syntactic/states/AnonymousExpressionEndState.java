package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.definitions.ExpressionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;

public class AnonymousExpressionEndState extends State
{
	private final FunctionDefinition function;
	private final ExpressionDefinition expression;
	
	public AnonymousExpressionEndState(ProgramDefinition program, FunctionDefinition function, ExpressionDefinition expression)
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
			return new AnonymousExpressionStartState(getProgram(), this.function, this.expression);
		}
		else if (token.type == Type.NEW_LINE)
		{
			this.function.addExpression(this.expression);
			addFunction(this.function);
			
			return new InitialState(getProgram());
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}