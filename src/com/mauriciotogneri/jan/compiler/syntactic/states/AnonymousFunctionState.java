package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.definitions.ExpressionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;

public class AnonymousFunctionState extends State
{
	private final FunctionDefinition function;
	
	public AnonymousFunctionState(ProgramDefinition program, FunctionDefinition function)
	{
		super(program);
		
		this.function = function;
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type.isSeparator())
		{
			return new AnonymousExpressionStartState(getProgram(), this.function, new ExpressionDefinition());
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}