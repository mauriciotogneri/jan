package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;

public class AnonymousFunctionState extends State
{
	private final Function function;
	
	public AnonymousFunctionState(Program program, Function function)
	{
		super(program);
		
		this.function = function;
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type.isSeparator())
		{
			return new AnonymousExpressionStartState(getProgram(), this.function, new Expression());
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}